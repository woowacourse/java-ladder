package ladder.domain.generator;

import java.util.List;

public class TestPointGenerator implements PointGenerator {

    private final List<Boolean> values;
    private int index = 0;

    public TestPointGenerator(List<Boolean> values) {
        this.values = values;
    }

    @Override
    public boolean generate() {
        return values.get(index++);
    }

}
