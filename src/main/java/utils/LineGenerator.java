package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import domain.Line;

public class LineGenerator {

    public static final Random RANDOM = new Random();

    public static Line generate(int userCount) {
        List<Boolean> lines = getLines(userCount);
        return new Line(lines);
    }

    private static List<Boolean> getLines(int userCount) {
        List<Boolean> lines = new ArrayList<>();
        boolean previousBar = RANDOM.nextBoolean();
        lines.add(previousBar);
        for (int i = 0; i < userCount - 2; i++) {
            boolean nextBar = convertBoolean(previousBar);
            lines.add(nextBar);
            previousBar = nextBar;
        }
        return lines;
    }

    private static boolean convertBoolean(boolean comparedBoolean) {
        if (comparedBoolean) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}
