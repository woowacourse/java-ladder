package ladder.util;

import java.util.List;
import ladder.domain.LadderGameCreateLineBooleanGenerator;

public class TestBooleanGenerator implements LadderGameCreateLineBooleanGenerator {

    private List<Boolean> booleans;
    private int index = 0;

    public TestBooleanGenerator(final List<Boolean> booleans) {
        this.booleans = booleans;
    }

    @Override
    public boolean generate() {
        return booleans.get(index++);
    }
}
