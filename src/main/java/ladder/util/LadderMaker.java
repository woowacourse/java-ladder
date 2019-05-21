package ladder.util;

import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {
    public static List<Line> generateAllPoints(int height, int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(generatePoints(countOfPerson)));
        }
        return lines;
    }

    private static List<Boolean> generatePoints(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        for (int j = 0; j < countOfPerson; j++) {
            points.add(RandomHelper.randomPoint(points, countOfPerson));
        }
        points.add(false);
        return points;
    }
}
