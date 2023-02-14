package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Raw {

    private final List<Boolean> points = new ArrayList<>();

    public Raw(int personCount) {
        for (int i = 0; i < personCount; i++) {
            points.add(false);
        }
    }

    public void createLine(int index, boolean isCreated){
        points.set(index, isCreated);
    }

    public boolean isPointHasLine(int index) {
        return points.get(index);
    }

}
