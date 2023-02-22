package domain;

import java.util.ArrayList;
import java.util.List;

import utils.LadderRowGenerator;

public class TestLadderRowGenerator implements LadderRowGenerator {
    private final List<List<Boolean>> ladder = List.of(
            List.of(false, true, false, true, false),
            List.of(false, false, true, false, false),
            List.of(false, true, false, false, false),
            List.of(false, false, true, false, false),
            List.of(false, true, false, true, false)
    );

    @Override
    public LadderRow generate(int userCount) {
        List<Point> points = new ArrayList<>();

        for (List<Boolean> booleans : ladder) {
            createPoint(points, booleans);
        }

        return new LadderRow(points);
    }

    private static void createPoint(List<Point> points, List<Boolean> booleans) {
        for (int i = 0; i < booleans.size() - 1; i++) {
            Point point = new Point(booleans.get(i), booleans.get(i + 1));
            points.add(point);
        }
    }
}
