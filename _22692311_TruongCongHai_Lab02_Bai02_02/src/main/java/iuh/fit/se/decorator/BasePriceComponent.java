package iuh.fit.se.decorator;

import iuh.fit.se.model.Product;

public class BasePriceComponent implements PriceComponent {
    private final Product product;

    public BasePriceComponent(Product product) {
        this.product = product;
    }

    @Override
    public double getBasePrice() {
        return product.basePrice();
    }

    @Override
    public double getTotalPrice() {
        return product.basePrice();
    }

    @Override
    public String getDescription() {
        return "Co so";
    }
}