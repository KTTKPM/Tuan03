package iuh.fit.se.state;

public class TaxContext {
    private TaxState currentState;

    public TaxContext(TaxState currentState) {
        this.currentState = currentState;
    }

    public void setState(TaxState newState) {
        this.currentState = newState;
    }

    public double applyState(double rawTax, String taxType) {
        return currentState.adjustTax(rawTax, taxType);
    }

    public String getStateName() {
        return currentState.getName();
    }
}