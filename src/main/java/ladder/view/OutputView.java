package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Name;
import ladder.domain.People;

import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_SIDE_SYMBOL = "|";
    private static final int LADDER_WIDTH = 5;
    private static final String FORMAT = "%6s";

    public void printError(String message) {
        System.out.println(message);
    }

    public void printPeople(People people) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();

        for (Name name : people.getNames()) {
            String formattedName = String.format(FORMAT, name);
            System.out.print(formattedName);
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        ladder.getLadder()
                .forEach(this::printLine);
    }

    private void printLine(Line line) {
        String prefixLadder = " ".repeat(LADDER_WIDTH) + LADDER_SIDE_SYMBOL;
        String points = line.getPoints().stream()
                .map(point -> point.repeatSymbol(LADDER_WIDTH))
                .collect(Collectors.joining(LADDER_SIDE_SYMBOL, prefixLadder, LADDER_SIDE_SYMBOL));
        System.out.println(points);
    }
}
