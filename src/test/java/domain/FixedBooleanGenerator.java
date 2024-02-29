package domain;

public class FixedBooleanGenerator implements BooleanGenerator {

    private final boolean value;

    public FixedBooleanGenerator(boolean value) {
        this.value = value;
    }

    @Override
    public boolean generate() {
        return value;
    }
}
