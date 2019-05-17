package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    Record drawLine(Record record) {
        List<Integer> beforeRecord = record.getIndices();
        int size = beforeRecord.size();
        checkSize(size);
        List<Boolean> tempPoints = new ArrayList<>(points);
        List<Integer> afterRecord = new ArrayList<>(Arrays.asList(new Integer[size]));

        tempPoints.add(0, false);
        tempPoints.add(tempPoints.size(), false);

        for (int i = 0; i < size; i++) {
            afterRecord.set(move(tempPoints.get(i), i, tempPoints.get(i + 1)), beforeRecord.get(i));
        }

        return new Record(afterRecord);
    }

    private void checkSize(int size) {
        if (size != points.size() + 1){
            throw new IllegalArgumentException();
        }
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
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("|");
        stringBuilder.append(this.points.stream().map(point -> point ? "-----|" : "     |").collect(Collectors.joining()));
        return stringBuilder.toString();
    }
}