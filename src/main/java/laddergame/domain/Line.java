package laddergame.domain;

import java.util.List;

public class Line {

    private final List<Boolean> points;
    
    private Line(final List<Boolean> points) {
        this.points = points;
    }

    public static Line create(final int size, final BooleanGenerator booleanGenerator) {
        List<Boolean> points = createPoints(size, booleanGenerator);

        Boolean temp = false;

        // TODO : 인댑스 줄이기
        for (int i = 0; i < size; i++) {
            Boolean now = points.get(i);
            if (now && temp) {
                points.set(i, !now);
                temp = !now;
                continue;
            }

            temp = now;
        }

        return new Line(points);
    }

    private static List<Boolean> createPoints(final int size, final BooleanGenerator booleanGenerator) {
        return booleanGenerator.generateUntil(size);
    }

    public List<Boolean> getPoints() {
        return points;
    }


    public int getSize() {
        return points.size();
    }
}
