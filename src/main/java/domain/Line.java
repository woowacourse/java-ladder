package domain;

import util.TrueOrFalseGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Line {
    private final TrueOrFalseGenerator trueOrFalseGenerator;
    private final List<Boolean> points;

    public Line(int personCount, TrueOrFalseGenerator trueOrFalseGenerator) {
        this.trueOrFalseGenerator = trueOrFalseGenerator;
        this.points = makeLine(personCount);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private List<Boolean> makeLine(int personCount) {
        List<Boolean> points = new ArrayList<>();
        int pointCount = personCount - 1;
        for (int count = 0; count < pointCount; count++) {
            points.add(correctOverLapPoints(points, trueOrFalseGenerator.generate(), count));
        }
        return points;
    }

    private Boolean correctOverLapPoints(List<Boolean> points, boolean current, int count) {
        if (points.size() == 0) {
            return current;
        }
        if (!points.get(count - 1) || !current) {
            return current;
        }
        return false;
    }

    public void checkFalseIndex(HashMap<Integer, Integer> map) {
        for (Boolean b : points) {
            if (!b) {
                Integer key = points.indexOf(b);
                if (map.containsKey(key)) {
                    Integer oldvalue = map.get(points.indexOf(b));
                    map.replace(points.indexOf(b), oldvalue, oldvalue + 1);
                    break;
                }
                map.put(key, 1);
            }
        }
    }
}
