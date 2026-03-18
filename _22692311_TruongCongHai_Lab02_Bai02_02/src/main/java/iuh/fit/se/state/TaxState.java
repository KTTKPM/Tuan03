package iuh.fit.se.state;

public interface TaxState {
    String getName();

    double adjustTax(double rawTax, String taxType);
}