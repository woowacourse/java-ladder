package ladder.util;

import java.util.List;
import java.util.Random;

public class RandomHelper {
    public static boolean randomPoint(List<Boolean> points, int countOfPerson) {
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
}
