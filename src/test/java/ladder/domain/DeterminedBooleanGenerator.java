package ladder.domain;

import java.util.List;

class DeterminedBooleanGenerator implements BooleanGenerator {
    private final List<Boolean> expects;

    public DeterminedBooleanGenerator(List<Boolean> expects) {
        this.expects = expects;
    }

    @Override
    public boolean generate() {
        return expects.remove(0);
    }
}
