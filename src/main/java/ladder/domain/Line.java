package ladder.domain;

import ladder.util.RandomHelper;

import java.util.*;

class Line {
    private final String CONSECUTIVE_EXCEPTION_MESSAGE = "연속된 true는 허용되지 않습니다.";
    private final List<Boolean> points;

    Line(final List<Boolean> points) {
        if (isConsecutive(points)) {
            throw new IllegalArgumentException(CONSECUTIVE_EXCEPTION_MESSAGE);
        }
        this.points = points;
    }

    private boolean isConsecutive(List<Boolean> points) {
        return Collections.indexOfSubList(points, Arrays.asList(true, true)) != -1;
    }

    static List<Boolean> generatePoints(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        for (int j = 0; j < countOfPerson; j++) {
            points.add(RandomHelper.randomPoint(points, countOfPerson));
        }
        points.add(false);
        return points;
    }

    String makeLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < points.size() - 1; i++) {
            sb.append(makeRow(i));
        }
        return sb.toString() + "\n";
    }

    private String makeRow(int index) {
        if (points.get(index)) {
            return "-----|";
        }
        return "     |";
    }

    int move(int index) {
        if (points.get(index)) {
            return ++index;
        }
        if (points.get(index - 1)) {
            return --index;
        }
        return index;
    }
}


