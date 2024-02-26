package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Name;
import ladder.domain.People;

import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_SIDE_SYMBOL = "|";

    public void printError(String message) {
        System.out.println(message);
    }

    public void printPeople(People people) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();

        String nameFormat = makeNameFormat(people);

        for (Name name : people.getNames()) {
            String formattedName = String.format(nameFormat, name);
            System.out.print(formattedName);
        }
        System.out.println();
    }

    private String makeNameFormat(People people) {
        int width = people.findMaxNameLength() + 1;
        return "%" + width + "s";
    }

    public void printLadder(Ladder ladder, People people) {
        ladder.getLadder()
                .forEach(line -> printLine(line, people.findMaxNameLength()));
    }

    private void printLine(Line line, int maxNameLength) {
        String prefixLadder = " ".repeat(maxNameLength) + LADDER_SIDE_SYMBOL;
        String points = line.getPoints().stream()
                .map(point -> point.repeatSymbol(maxNameLength))
                .collect(Collectors.joining(LADDER_SIDE_SYMBOL, prefixLadder, LADDER_SIDE_SYMBOL));
        System.out.println(points);
    }
}
