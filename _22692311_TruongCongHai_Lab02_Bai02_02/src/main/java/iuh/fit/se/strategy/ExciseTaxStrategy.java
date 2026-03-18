package iuh.fit.se.strategy;

public class ExciseTaxStrategy implements TaxStrategy {
    private final double rate;

    public ExciseTaxStrategy(double rate) {
        this.rate = rate;
    }

    @Override
    public String getType() {
        return "EXCISE";
    }

    @Override
    public double calculate(double basePrice) {
        return basePrice * rate;
    }

    @Override
    public String getLabel() {
        return "Thue tieu thu " + (int) (rate * 100) + "%";
    }
}