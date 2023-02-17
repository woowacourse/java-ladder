package ladder.domain.generator;

import ladder.domain.generator.LineGenerator;

import java.util.List;

public class TestLineGenerator implements LineGenerator {

    private final List<Boolean> values;
    private int index = 0;

    public TestLineGenerator(List<Boolean> values) {
        this.values = values;
    }

    @Override
    public boolean generate() {
        return values.get(index++);
    }

}
