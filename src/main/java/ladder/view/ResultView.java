package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Names;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ResultView {
    private static final int WIDTH = 5;
    private static final String LEG = "|";
    private static final String BLANK = " ";
    private static final String NAME_FORMAT = "%5s";

    public void printResult(Names names, Ladder ladder) {
        System.out.println("실행결과\n");

        printNames(names);
        printLadder(ladder, names.lengthOfFirstName());
    }

    private void printNames(Names names) {
        String result = names.getNames()
                .stream()
                .map(name -> String.format(NAME_FORMAT, name) + BLANK)
                .collect(Collectors.joining());
        System.out.println(result.trim());
    }

    private void printLadder(Ladder ladder, int lengthOfFirstName) {
        for (Line line : ladder) {
            String result = BLANK.repeat(lengthOfFirstName - 1);
            result += getShapeOf(line);
            result += LEG;
            System.out.println(result);
        }
    }

    private String getShapeOf(Line line) {
        return line.getLine()
                .stream()
                .map(LadderFormat::getComponent)
                .map(component -> LEG + component.repeat(WIDTH))
                .collect(Collectors.joining());
    }

    private enum LadderFormat {
        LINE(Boolean.TRUE, "-"),
        BLANK(Boolean.FALSE, " ");

        private final Boolean condition;
        private final String component;

        LadderFormat(Boolean condition, String component) {
            this.condition = condition;
            this.component = component;
        }

        public static String getComponent(Boolean condition) {
            return Arrays.stream(values())
                    .filter(format -> format.condition == condition)
                    .findAny()
                    .get()
                    .component;
        }
    }
}
