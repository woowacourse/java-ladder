package domain;

import java.util.List;

class PickedPointGenerator implements PointGenerator {

    private List<Boolean> test;
    private int index = 0;

    public PickedPointGenerator(final List<Boolean> test) {
        this.test = test;
    }

    @Override
    public boolean generate() {
        final Boolean point = test.get(index % test.size());
        index++;
        return point;
    }
}
