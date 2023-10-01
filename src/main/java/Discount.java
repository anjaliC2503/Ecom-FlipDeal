public class Discount {

    public Discount(String discountTag, Double amount) {
        this.discountTag = discountTag;
        this.amount = amount;
    }

    public String getDiscountTag() {
        return discountTag;
    }

    public void setDiscountTag(String discountTag) {
        this.discountTag = discountTag;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    private String discountTag;
    private Double amount;
}
