package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    Record drawLine(Record record) {
        List<Integer> beforeRecord = record.getIndices();
        List<Boolean> tempPoints = new ArrayList<>(points);
        List<Integer> afterRecord = new ArrayList<>();

        tempPoints.add(0, false);
        tempPoints.add(tempPoints.size(), false);

        int length = beforeRecord.size();

        for (int i = 0; i < length; i++) {
            afterRecord.add(beforeRecord.get(i), move(tempPoints.get(i), i, tempPoints.get(i + 1)));
        }

        return new Record(afterRecord);
    }

    private int move(boolean left, int index, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
        if (left) {
            return --index;
        }
        if (right) {
            return ++index;
        }
        return index;
    }
}