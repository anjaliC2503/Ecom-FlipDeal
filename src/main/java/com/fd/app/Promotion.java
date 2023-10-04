package com.fd.app;

import java.util.*;

public enum Promotion {

    promotionSetA {
        @Override
        public List<DiscountedProductDetails> getDiscountedProducts(List<ProductDetails> products) {
            List<DiscountedProductDetails> discountedProducts = new ArrayList<>();
            Set<String> discountedCategories = new HashSet<>();
            discountedCategories.add("electronics");
            discountedCategories.add("furnishing");
            products.forEach(product -> {
                List<Discount> discounts = new ArrayList<>();
                //origin
                if("Africa".equals(product.getOrigin())) {
                    discounts.add(new Discount("get 2% off", 0.02*product.getPrice()));
                }
                //rating
                if(product.getRating() <= 2.0) {
                    if(product.getRating() == 2.0)
                        discounts.add(new Discount("get 4% off", 0.04*product.getPrice()));
                    else discounts.add(new Discount("get 8% off", 0.08*product.getPrice()));
                }
                //category
                if(discountedCategories.contains(product.getCategory()) && product.getPrice() > 500) {
                    discounts.add(new Discount("get Rs 100 off", product.getPrice()-100.0));
                }
                if(discounts.isEmpty()) {
                    if(product.getPrice() > 1000)
                        discountedProducts.add(new DiscountedProductDetails(product, getDefaultDiscount(product)));
                    else discountedProducts.add(new DiscountedProductDetails(product));
                } else {
                    discountedProducts.add(new DiscountedProductDetails(product,
                            discounts.stream().max(Comparator.comparing(Discount::getAmount)).get()));
                }
            });
            return discountedProducts;
        }
    },
    promotionSetB {
        @Override
        public List<DiscountedProductDetails> getDiscountedProducts(List<ProductDetails> products) {
            List<DiscountedProductDetails> discountedProducts = new ArrayList<>();
            products.forEach(product -> {
                List<Discount> discounts = new ArrayList<>();

                //inventory
                if(product.getInventory() > 20) {
                    discounts.add(new Discount("get 12% off", 0.12*product.getPrice()));
                }
                //arrival
                if("NEW".equals(product.getArrival())) {
                    discounts.add(new Discount("get 7% off", 0.07*product.getPrice()));
                }
                if(discounts.isEmpty()) {
                    if(product.getPrice() > 1000)
                        discountedProducts.add(new DiscountedProductDetails(product, getDefaultDiscount(product)));
                    else discountedProducts.add(new DiscountedProductDetails(product));
                } else {
                    discountedProducts.add(new DiscountedProductDetails(product,
                            discounts.stream().max(Comparator.comparing(Discount::getAmount)).get()));
                }
            });
            return discountedProducts;
        }
    };
    
    public abstract List<DiscountedProductDetails> getDiscountedProducts(List<ProductDetails> products);

    public Discount getDefaultDiscount(ProductDetails product) {
        return new Discount("get 2% off", product.getPrice()*0.02);
    }

}
