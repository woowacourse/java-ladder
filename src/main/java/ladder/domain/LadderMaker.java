package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderMaker {
    static boolean randomPoint(List<Boolean> points, int countOfPerson) {
        Random random = new Random();
        if (countOfPerson == 1 || (points.size() != 0 && points.get(points.size() - 1))) {
            return false;
        }
        return random.nextBoolean();
    }

    static List<Boolean> generateAllPoints(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < countOfPerson; i++) {
            points.add(randomPoint(points, countOfPerson));
        }
        return points;
    }
}
