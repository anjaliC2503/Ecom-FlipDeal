import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class DiscountApplication {
    private static final ObjectMapper objectmapper = new ObjectMapper();

    public static void main(String[] args) throws IOException, URISyntaxException {

        //parse arguments
        String promotionParam = args[0];
        Promotion promotion = null;
        try{
            promotion = Enum.valueOf(Promotion.class, promotionParam);
        } catch (Exception e) {
            System.out.println("Wrong param for promotion set!");
            System.exit(1);
        }

        HttpResponse<String> productsResponse = ServiceRequest.callGetAPI("https://mock.coverself.net/rest/hiring/products");
        List<ProductDetails> productList = objectmapper.readValue(productsResponse.body(), new TypeReference<List<ProductDetails>>() {});

        //price conversion
        HttpResponse<String> exchangeRatesResponse = ServiceRequest.callGetAPI("https://mock.coverself.net/rest/hiring/exchange-rates");
        ExchangeRate exchangeRates = objectmapper.readValue(exchangeRatesResponse.body(), ExchangeRate.class);

        productList.forEach(product -> {
            product.setPrice(product.getPrice() / exchangeRates.getRates().get(product.getCurrency()));
            product.setCurrency("INR");
        });

        //discount calculation
        List<DiscountedProductDetails> discountedProductDetails = Objects.requireNonNull(promotion).getDiscountedProducts(productList);

        //write to file
        Path targetPath = Paths.get(DiscountApplication.class.getResource("/").toURI()).getParent();
        File outputFile = new File(targetPath + "/output.json");
        objectmapper.writeValue(outputFile, discountedProductDetails);

        System.out.println("Successfully associated each product with the appropriate discount!!");

    }

}