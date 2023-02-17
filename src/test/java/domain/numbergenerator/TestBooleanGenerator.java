package domain.numbergenerator;

import java.util.List;

public class TestBooleanGenerator implements BooleanGenerator {

    private final List<Boolean> booleans;

    public TestBooleanGenerator(List<Boolean> booleans) {
        this.booleans = booleans;
    }

    @Override
    public boolean generate() {
        return booleans.remove(0);
    }
}
