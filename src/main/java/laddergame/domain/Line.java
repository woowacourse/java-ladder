package laddergame.domain;

import laddergame.util.TrueOrFalseGenerator;

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

    public boolean isStep(int position) {
        if (position < 0 || position > points.size() - 1) {
            return false;
        }
        return points.get(position);
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

    public HashMap<Integer, Integer> checkFalseIndex(HashMap<Integer, Integer> map) {
        Integer key = 0;
        for (Boolean isStep : points) {
            insertFalseIndexToMap(isStep, map, key);
            key++;
        }
        return map;
    }

    private void insertFalseIndexToMap(Boolean isStep, HashMap<Integer, Integer> map, Integer key) {
        if (isStep) {
            return;
        }
        if (map.containsKey(key)) {
            Integer oldValue = map.get(key);
            map.replace(key, oldValue, oldValue + 1);
            return;
        }
        map.put(key, 1);
    }
}
