import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class DiscountedProductDetails extends ProductDetails {

    @JsonProperty(value = "discount")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Discount discount;
    public DiscountedProductDetails(ProductDetails product, Discount discount) {
        super(product);
        this.discount = discount;
    }
    public DiscountedProductDetails(ProductDetails product) {
        super(product);
    }

    public DiscountedProductDetails() {
    }
}
