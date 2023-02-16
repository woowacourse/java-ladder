package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Row {

    private final List<Boolean> points = new ArrayList<>();

    public Row(int personCount, LineCreateDecider lineCreateDecider) {
        for (int i = 0; i < personCount - 1; i++) {
            createLineAt(i, lineCreateDecider.decide());
        }
    }

    private void createLineAt(int point, boolean isCreated) {
        if(isLeftPointHasLine(point)){
            points.add(false);
            return;
        }
        points.add(isCreated);
    }

    private boolean isLeftPointHasLine(int point) {
        if(point == 0){
            return false;
        }
        return points.get(point - 1);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
