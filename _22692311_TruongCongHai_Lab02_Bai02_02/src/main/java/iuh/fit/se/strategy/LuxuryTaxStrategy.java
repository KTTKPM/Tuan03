package iuh.fit.se.strategy;

public class LuxuryTaxStrategy implements TaxStrategy {
    private final double rate;

    public LuxuryTaxStrategy(double rate) {
        this.rate = rate;
    }

    @Override
    public String getType() {
        return "LUXURY";
    }

    @Override
    public double calculate(double basePrice) {
        return basePrice * rate;
    }

    @Override
    public String getLabel() {
        return "Thue xa xi " + (int) (rate * 100) + "%";
    }
}