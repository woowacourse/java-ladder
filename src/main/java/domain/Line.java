package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int personCount) {
        Random random = new Random();
        for (int i = 0; i < personCount-1; i++) {
            boolean isTrue = random.nextBoolean();
            if (i != 0 && points.get(i - 1) == true) {
                if (isTrue) {
                    points.add(false);
                } else {
                    points.add(false);
                }
            } else {
                points.add(isTrue);
            }
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
