package util;

import view.LadderItem;

public class TestLadderItemGenerator implements LadderItemGenerator {

    private final LadderItem isConnectable;

    public TestLadderItemGenerator(LadderItem isConnectable) {
        this.isConnectable = isConnectable;
    }

    @Override
    public LadderItem generate() {
        return isConnectable;
    }
}
