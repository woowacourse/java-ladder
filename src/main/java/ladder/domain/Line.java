package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final String DEFAULT_BAR = "|";

    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    Record drawLine(Record record) {
        List<Integer> beforeRecord = record.getIndices();
        int size = beforeRecord.size();
        checkSize(size);
        List<Integer> afterRecord = new ArrayList<>(Arrays.asList(new Integer[size]));

        for (int i = 0; i < size; i++) {
            afterRecord.set(i + points.get(i).move(), beforeRecord.get(i));
        }

        return new Record(afterRecord);
    }

    private void checkSize(int size) {
        if (size != points.size()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return DEFAULT_BAR + this.points.stream().map(Point::toString).collect(Collectors.joining(DEFAULT_BAR));
    }
}