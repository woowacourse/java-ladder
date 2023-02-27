package util;

import java.util.List;

public class TestGenerator implements BooleanGenerator {
    private final List<Boolean> list;
    private int index = 0;

    public TestGenerator(List<Boolean> list) {
        this.list = list;
    }

    @Override
    public Boolean generate() {
        return list.get(index++);
    }
}
