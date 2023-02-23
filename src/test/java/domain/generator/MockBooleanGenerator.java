package domain.generator;

import java.util.List;

public class MockBooleanGenerator implements BooleanGenerator {
    private final List<Boolean> values;
    private int index = 0;

    public MockBooleanGenerator(List<Boolean> values) {
        this.values = values;
    }

    @Override
    public boolean generate() {
        return values.get(index++);
    }
}
