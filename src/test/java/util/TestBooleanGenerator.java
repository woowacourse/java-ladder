package util;

public class TestBooleanGenerator implements BooleanGenerator {

    private final Boolean isConnectable;

    public TestBooleanGenerator(Boolean isConnectable) {
        this.isConnectable = isConnectable;
    }

    @Override
    public Boolean generate() {
        return isConnectable;
    }
}
