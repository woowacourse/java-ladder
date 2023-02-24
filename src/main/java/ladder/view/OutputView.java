package ladder.view;

import java.util.stream.Collectors;

import ladder.domain.FootBars;
import ladder.domain.Ladder;
import ladder.domain.LadderFormat;
import ladder.domain.Names;
import ladder.domain.Results;

public class OutputView {
    private static final int WIDTH = 5;
    private static final String LEG = "|";
    private static final String BLANK = " ";
    private static final String NAME_FORMAT = "%5s";
    private static final String RESULT_FORMAT = "%5s";

    public void printLadderShape(Names names, Results results, Ladder ladder) {
        printInfo();
        printNames(names);
        printLadderShape(ladder);
        printResults(results);
    }

    private void printInfo() {
        printEmptyLine();
        System.out.println("사다리 결과");
        printEmptyLine();
    }

    private void printNames(Names names) {
        String nameRow = names.getNames()
            .stream()
            .map(name -> String.format(NAME_FORMAT, name.getName()) + BLANK)
            .collect(Collectors.joining());

        System.out.println(nameRow);
    }

    private void printLadderShape(Ladder ladder) {
        for (FootBars footBars : ladder.getLadder()) {
            String result = BLANK.repeat(WIDTH - 1);
            result += shapeOf(footBars);
            result += LEG;
            System.out.println(result);
        }
    }

    private String shapeOf(FootBars footBars) {
        return footBars.getFootBars()
            .stream()
            .map(LadderFormat::getComponent)
            .map(component -> LEG + component.repeat(WIDTH))
            .collect(Collectors.joining());
    }

    private void printResults(Results results) {
        String resultsRow = results.getResults()
            .stream()
            .map(result -> String.format(RESULT_FORMAT, result.getResult()) + BLANK)
            .collect(Collectors.joining());
        System.out.println(resultsRow);
        printEmptyLine();
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printMatchResult(String matchResult) {
        printEmptyLine();
        System.out.println("실행 결과");
        System.out.println(matchResult);
        printEmptyLine();
    }
}
