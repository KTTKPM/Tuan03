package iuh.fit.se.state;

public class StandardTaxState implements TaxState {
    @Override
    public String getName() {
        return "THUONG";
    }

    @Override
    public double adjustTax(double rawTax, String taxType) {
        return rawTax;
    }
}