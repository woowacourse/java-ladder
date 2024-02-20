package ladder.domain;

public class Energy {

    private static final int ENERGY_THRESHOLD = 5;
    private final NumberGenerator numberGenerator;

    public Energy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean isEnergetic() {
        return numberGenerator.getRandomNumberInRange() > ENERGY_THRESHOLD;
    }
}
