package util;

import domain.LadderItem;

public class TestBooleanGenerator implements BooleanGenerator {

    private final LadderItem isConnectable;

    public TestBooleanGenerator(LadderItem isConnectable) {
        this.isConnectable = isConnectable;
    }

    @Override
    public LadderItem generate() {
        return isConnectable;
    }
}
