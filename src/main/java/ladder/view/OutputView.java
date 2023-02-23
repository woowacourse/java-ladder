package ladder.view;

import java.util.stream.Collectors;

import ladder.domain.Ladder;
import ladder.domain.LadderFormat;
import ladder.domain.Line;
import ladder.domain.Names;
import ladder.domain.Results;

public class OutputView {
    private static final int WIDTH = 5;
    private static final String LEG = "|";
    private static final String BLANK = " ";
    private static final String NAME_FORMAT = "%5s";
    private static final String RESULT_FORMAT = "%5s";

    public void printLadder(Names names, Results results, Ladder ladder) {
        printNames(names);
        printLadder(ladder);
        printResults(results);
    }

    private void printNames(Names names) {
        String nameLine = names.getNames()
            .stream()
            .map(name -> String.format(NAME_FORMAT, name.getName()) + BLANK)
            .collect(Collectors.joining());
        printEmptyLine();
        System.out.println("사다리 결과");
        printEmptyLine();
        System.out.println(nameLine);
    }

    private void printLadder(Ladder ladder) {
        for (Line line : ladder) {
            String result = BLANK.repeat(WIDTH - 1);
            result += shapeOf(line);
            result += LEG;
            System.out.println(result);
        }
    }

    private void printResults(Results results) {
        String resultLine = results.getResults()
            .stream()
            .map(result -> String.format(RESULT_FORMAT, result.getResult()) + BLANK)
            .collect(Collectors.joining());
        System.out.println(resultLine);
        printEmptyLine();
    }

    private String shapeOf(Line line) {
        return line.getLine()
            .stream()
            .map(LadderFormat::getComponent)
            .map(component -> LEG + component.repeat(WIDTH))
            .collect(Collectors.joining());
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printMatching(String matchingResult) {
        printEmptyLine();
        System.out.println("실행 결과");
        System.out.println(matchingResult);
        printEmptyLine();
    }
}
