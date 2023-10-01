import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDetails {
    public ProductDetails() {
    }
    public ProductDetails(ProductDetails productDetails) {
        this.category = productDetails.getCategory();
        this.inventory = productDetails.getInventory();
        this.rating = productDetails.getRating();
        this.currency = productDetails.getCurrency();
        this.price = productDetails.getPrice();
        this.origin = productDetails.getOrigin();
        this.product = productDetails.getProduct();
        this.arrival = productDetails.getArrival();
    }
    public ProductDetails(String category, int inventory, Double rating, String currency, Double price, String origin, String product, String arrival) {
        this.category = category;
        this.inventory = inventory;
        this.rating = rating;
        this.currency = currency;
        this.price = price;
        this.origin = origin;
        this.product = product;
        this.arrival = arrival;
    }
    private String category;
    private int inventory;
    private Double rating;
    private String currency;
    private Double price;
    private String origin;
    private String product;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String arrival;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getCurrency() {
        return currency;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

}
