package domain;

import java.util.ArrayList;
import java.util.List;

class PickedPointGenerator implements PointGenerator{

    private List<Boolean> test = List.of(false, true, false);
    private int index = 0;
    @Override
    public boolean generate() {
        return test.get(index++);
    }
}
