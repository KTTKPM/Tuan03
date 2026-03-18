package iuh.fit.se.decorator;

import iuh.fit.se.state.TaxContext;
import iuh.fit.se.strategy.ExciseTaxStrategy;

public class ExciseDecorator extends TaxDecorator {
    public ExciseDecorator(PriceComponent component, TaxContext taxContext, ExciseTaxStrategy strategy) {
        super(component, taxContext, strategy);
    }
}