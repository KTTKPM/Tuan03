package iuh.fit.se.state;

public class TaxHolidayState implements TaxState {
    @Override
    public String getName() {
        return "UU_DAI_THUE";
    }

    @Override
    public double adjustTax(double rawTax, String taxType) {
        if ("VAT".equals(taxType)) {
            return rawTax * 0.5;
        }
        return rawTax * 0.8;
    }
}