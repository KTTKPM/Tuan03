package iuh.fit.se.state;

public class LuxuryControlState implements TaxState {
    @Override
    public String getName() {
        return "KIEM_SOAT_XA_XI";
    }

    @Override
    public double adjustTax(double rawTax, String taxType) {
        if ("LUXURY".equals(taxType)) {
            return rawTax * 1.25;
        }
        return rawTax;
    }
}