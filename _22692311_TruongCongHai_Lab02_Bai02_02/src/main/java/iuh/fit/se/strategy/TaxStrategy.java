package iuh.fit.se.strategy;

public interface TaxStrategy {
    String getType();

    double calculate(double basePrice);

    String getLabel();
}