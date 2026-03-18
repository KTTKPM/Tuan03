package iuh.fit.se.decorator;

public interface PriceComponent {
    double getBasePrice();

    double getTotalPrice();

    String getDescription();
}