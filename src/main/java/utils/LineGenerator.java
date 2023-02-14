package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Line;

public class LineGenerator {

    public static Line generate(Line previousLine) {
        List<Boolean> lines = previousLine.getLine();

        List<Boolean> newLines = lines.stream()
                .map(LineGenerator::convertBoolean)
                .collect(Collectors.toList());
        return new Line(newLines);
    }

    private static boolean convertBoolean(boolean comparedBoolean) {
        if(comparedBoolean) {
            return false;
        }
        return false;
    }
}
