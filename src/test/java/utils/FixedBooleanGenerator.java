package utils;

public class FixedBooleanGenerator implements BooleanGenerator {
    private final boolean inputBool;

    public FixedBooleanGenerator(boolean inputBool) {
        this.inputBool = inputBool;
    }

    @Override
    public boolean isMovable() {
        return inputBool;
    }
}
