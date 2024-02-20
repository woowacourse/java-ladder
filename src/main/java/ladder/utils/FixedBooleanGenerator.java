package ladder.utils;

public class FixedBooleanGenerator implements BooleanGenerator{
    private final boolean fixedValue;

    public FixedBooleanGenerator(boolean value) {
        this.fixedValue = value;
    }

    @Override
    public Boolean generate() {
        return fixedValue;
    }
}
