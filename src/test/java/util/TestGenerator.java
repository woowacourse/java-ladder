package util;

import domain.Bridge;
import java.util.List;

public class TestGenerator implements BridgeGenerator {
    private final List<Boolean> list;
    private int index = 0;

    public TestGenerator(List<Boolean> list) {
        this.list = list;
    }

    @Override
    public Bridge generate() {
        return Bridge.from(list.get(index++));
    }
}
