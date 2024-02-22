package util;

public class TestBooleanGenerator implements BooleanGenerator {

    private final boolean isConnectable;

    public TestBooleanGenerator(boolean isConnectable) {
        this.isConnectable = isConnectable;
    }

    @Override
    public boolean generate() {
        return isConnectable;
    }
}
