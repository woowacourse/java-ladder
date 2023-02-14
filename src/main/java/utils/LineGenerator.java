package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import domain.Line;

public class LineGenerator {

    public static final Random RANDOM = new Random();

    public static Line generate(Line previousLine) {
        List<Boolean> lines = previousLine.getExistedLine();

        List<Boolean> newLines = lines.stream()
                .map(LineGenerator::convertBoolean)
                .collect(Collectors.toList());
        return new Line(newLines);
    }

    public static Line generateFirstLine(int height) {
        List<Boolean> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(RANDOM.nextBoolean());
        }
        return new Line(lines);
    }

    private static boolean convertBoolean(boolean comparedBoolean) {
        if (comparedBoolean) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}
