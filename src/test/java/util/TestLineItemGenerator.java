package util;

import view.LineItem;

public class TestLineItemGenerator implements LineItemGenerator {

    private final LineItem lineItem;

    public TestLineItemGenerator(LineItem lineItem) {
        this.lineItem = lineItem;
    }

    @Override
    public LineItem generate() {
        return lineItem;
    }
}
