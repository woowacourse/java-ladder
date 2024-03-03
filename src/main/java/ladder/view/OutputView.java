package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String LADDER_SIDE_SYMBOL = "|";
    private static final int LADDER_WIDTH = 5;
    private static final String FORMAT = "%6s";

    public void printError(String message) {
        System.out.println(message);
    }

    public void printGame(People people, Ladder ladder, Results results) {
        printPeople(people);
        printLadder(ladder);
        printResults(results);
    }

    private void printPeople(People people) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();

        for (Target name : people.getNames()) {
            String formattedName = String.format(FORMAT, name);
            System.out.print(formattedName);
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        ladder.getLadder()
                .forEach(this::printLine);
    }

    private void printLine(Line line) {
        String prefixLadder = " ".repeat(LADDER_WIDTH) + LADDER_SIDE_SYMBOL;
        List<Point> points = line.getPoints();
        StringJoiner formattedLadder = new StringJoiner(LADDER_SIDE_SYMBOL, prefixLadder, LADDER_SIDE_SYMBOL);
        for (int i = 0; i < points.size() - 1; i++) {
            String ladder = points.get(i).repeatSymbol(LADDER_WIDTH);
            formattedLadder.add(ladder);
        }
        System.out.println(formattedLadder);
    }

    private void printResults(Results results) {
        for (Result result : results.getResults()) {
            String formattedResult = String.format(FORMAT, result);
            System.out.print(formattedResult);
        }
        System.out.println();
    }

    public void printPlayResultNotice() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printPlayResult(PlayResults playResults) {
        for (Target name : playResults.getNames()) {
            String formattedResult = getFormattedResult(playResults, name);
            System.out.println(formattedResult);
        }
    }

    private String getFormattedResult(PlayResults playResults, Target target) {
        StringJoiner stringJoiner = new StringJoiner(" : ");
        if (playResults.size() > 1) {
            stringJoiner.add(target.toString());
        }
        Result result = playResults.find(target);
        return stringJoiner.add(result.toString()).toString();
    }
}
