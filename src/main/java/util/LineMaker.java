package util;

import domain.LineStatus;
import java.util.List;

public class LineMaker {

    public static void makeFirstLineStatus(LineGenerator lineGenerator, List<LineStatus> line) {
        line.add(LineStatus.findBy(lineGenerator.generate(false)));
    }

    public static void makeElseLineStatus(LineGenerator lineGenerator, List<LineStatus> line, int numberOfLine) {
        for (int i = 1; i < numberOfLine; i++) {
            int leftIndex = i - 1;
            line.add(LineStatus.findBy(lineGenerator.generate(line.get(leftIndex).getStatus())));
        }
    }
}
