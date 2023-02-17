package ladder.view;

import java.util.stream.Collectors;

import ladder.domain.Ladder;
import ladder.domain.LadderFormat;
import ladder.domain.Line;
import ladder.domain.Names;

public class OutputView {
    private static final int WIDTH = 5;
    private static final String LEG = "|";
    private static final String BLANK = " ";
    private static final String NAME_FORMAT = "%5s";

    public void printResult(Names names, Ladder ladder) {
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
            result += shapeOf(line);
            result += LEG;
            System.out.println(result);
        }
    }

    private String shapeOf(Line line) {
        return line.getLine()
            .stream()
            .map(LadderFormat::getComponent)
            .map(component -> LEG + component.repeat(WIDTH))
            .collect(Collectors.joining());
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
