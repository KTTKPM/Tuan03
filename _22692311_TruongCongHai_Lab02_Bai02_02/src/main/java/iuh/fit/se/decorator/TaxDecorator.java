package iuh.fit.se.decorator;

import iuh.fit.se.state.TaxContext;
import iuh.fit.se.strategy.TaxStrategy;

public abstract class TaxDecorator implements PriceComponent {
    private final PriceComponent component;
    private final TaxContext taxContext;
    private final TaxStrategy strategy;

    protected TaxDecorator(PriceComponent component, TaxContext taxContext, TaxStrategy strategy) {
        this.component = component;
        this.taxContext = taxContext;
        this.strategy = strategy;
    }

    @Override
    public double getBasePrice() {
        return component.getBasePrice();
    }

    @Override
    public double getTotalPrice() {
        double rawTax = strategy.calculate(component.getBasePrice());
        double adjustedTax = taxContext.applyState(rawTax, strategy.getType());
        return component.getTotalPrice() + adjustedTax;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + " + " + strategy.getLabel();
    }
}