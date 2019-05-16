package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderMaker {

    public static List<Line> generateLadder(int height, int countOfPerson) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(generateAllPoints(countOfPerson)));
        }
        return ladder;
    }

    static boolean randomPoint(List<Boolean> points, int countOfPerson) {
        Random random = new Random();
        if (isOnePerson(countOfPerson) || isStartEnd(points, countOfPerson) || isFormerFalse(points)) {
            return false;
        }
        return random.nextBoolean();
    }

    private static boolean isOnePerson(int countOfPerson) {
        return countOfPerson == 1;
    }

    private static boolean isStartEnd(List<Boolean> points, int countOfPerson) {
        return (points.size() == 0 || points.size() == countOfPerson);
    }

    private static boolean isFormerFalse(List<Boolean> points) {
        return (points.size() != 0 && points.get(points.size() - 1));
    }

    private static List<Boolean> generateAllPoints(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < countOfPerson; i++) {
            points.add(randomPoint(points, countOfPerson));
        }
        points.add(false);
        return points;
    }
}
