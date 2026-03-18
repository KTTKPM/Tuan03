package iuh.fit.se.decorator;

import iuh.fit.se.state.TaxContext;
import iuh.fit.se.strategy.LuxuryTaxStrategy;

public class LuxuryDecorator extends TaxDecorator {
    public LuxuryDecorator(PriceComponent component, TaxContext taxContext, LuxuryTaxStrategy strategy) {
        super(component, taxContext, strategy);
    }
}