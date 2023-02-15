package ladder.view;

import java.util.stream.Collectors;

import ladder.domain.Ladder;
import ladder.domain.LadderFormat;
import ladder.domain.Line;
import ladder.domain.Names;

public class ResultView {
    private static final String LEG = "|";
    private static final String BLANK = " ";

    public static void printResult(Names names, Ladder ladder) {
        printNames(names);
        printLadder(ladder, names);
    }

    private static void printNames(Names names) {
        int maxNameLength = names.getMaxNameLength();

        String result = names.getNames().stream()
            .map(name -> BLANK.repeat(getCountOfNecessaryBlank(maxNameLength, name.getLength())) + name)
            .collect(Collectors.joining());
        System.out.println(result.trim());
    }

    private static int getCountOfNecessaryBlank(int maxNameLength, int nameLength) {
        return maxNameLength - nameLength + 1;
    }

    private static void printLadder(Ladder ladder, Names names) {
        for (Line line : ladder) {
            String result = BLANK.repeat(names.getFirstNameLength());
            result += getShapeOf(line, names.getMaxNameLength());
            result += LEG;
            System.out.println(result);
        }
    }

    private static String getShapeOf(Line line, int maxNameLength) {
        return line.getLine().stream()
            .map(LadderFormat::getComponent)
            .map(component -> LEG + component.repeat(maxNameLength))
            .collect(Collectors.joining());
    }
}
