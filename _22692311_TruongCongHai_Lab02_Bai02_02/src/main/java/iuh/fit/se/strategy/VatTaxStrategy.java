package iuh.fit.se.strategy;

public class VatTaxStrategy implements TaxStrategy {
    private final double rate;

    public VatTaxStrategy(double rate) {
        this.rate = rate;
    }

    @Override
    public String getType() {
        return "VAT";
    }

    @Override
    public double calculate(double basePrice) {
        return basePrice * rate;
    }

    @Override
    public String getLabel() {
        return "VAT " + (int) (rate * 100) + "%";
    }
}