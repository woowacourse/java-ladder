package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    // TODO : Boolean 이 뭘 의지하는지 알기 쉽나? Enum 으로 상태를 나타내는 것은 어떨까?
    private final List<Boolean> points;
    
    private Line(final List<Boolean> points) {
        this.points = points;
    }

    public static Line create(final int size, final BooleanGenerator booleanGenerator) {
        List<Boolean> points = new ArrayList<>();

        boolean temp = false;

        while (points.size() < size) {
            final boolean point = generateBoolean(temp, booleanGenerator);
            points.add(point);
            temp = point;
        }

        return new Line(points);
    }

    private static boolean generateBoolean(final boolean before, final BooleanGenerator booleanGenerator) {
        if (before) {
            return false;
        }

        return booleanGenerator.generate();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
