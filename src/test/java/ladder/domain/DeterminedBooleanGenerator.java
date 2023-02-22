package ladder.domain;

import java.util.List;

class DeterminedBooleanGenerator implements BooleanGenerator {
    private final List<Boolean> bars;

    public DeterminedBooleanGenerator(List<Boolean> bars) {
        this.bars = bars;
    }

    @Override
    public boolean generate() {
        return bars.remove(0);
    }
}
