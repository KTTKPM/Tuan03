package iuh.fit.se.decorator;

import iuh.fit.se.state.TaxContext;
import iuh.fit.se.strategy.VatTaxStrategy;

public class VatDecorator extends TaxDecorator {
    public VatDecorator(PriceComponent component, TaxContext taxContext, VatTaxStrategy strategy) {
        super(component, taxContext, strategy);
    }
}