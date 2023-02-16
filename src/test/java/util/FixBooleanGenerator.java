package util;

public class FixBooleanGenerator implements BooleanGenerator {

    private final boolean[] fixedBoolean;
    private int current = 0;

    public FixBooleanGenerator(final boolean... fixedBoolean) {
        this.fixedBoolean = fixedBoolean;
    }

    @Override
    public boolean generate() {
        return fixedBoolean[current++];
    }
}