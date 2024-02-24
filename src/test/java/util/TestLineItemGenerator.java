package util;

import domain.LineItem;

public class TestLineItemGenerator implements LineItemGenerator {

    private final LineItem isConnectable;

    public TestLineItemGenerator(LineItem isConnectable) {
        this.isConnectable = isConnectable;
    }

    @Override
    public LineItem generate() {
        return isConnectable;
    }
}
