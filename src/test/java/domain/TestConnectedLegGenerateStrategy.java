package domain;

public class TestConnectedLegGenerateStrategy implements LegGenerateStrategy {
    @Override
    public Leg generateLeg() {
        return Leg.CONNECTED;
    }
}
