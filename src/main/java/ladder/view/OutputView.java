package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.People;

import java.util.stream.Collectors;

public class OutputView {

    private static final int MAX_NAME_LENGTH = 5;

    public static void printError(String message) {
        System.out.println(message);
    }

    public void printResult(People people, Ladder ladder) {
        System.out.println("\n실행결과\n");

        String formattedNames = makeNamesFormatted(people);
        System.out.println(formattedNames);

        String formattedLadder = makeLadderFormatted(ladder);
        System.out.println(formattedLadder);
    }

    private String makeNamesFormatted(People people) {
        return people.getNames().stream()
                .map(this::makeNameFormatted)
                .collect(Collectors.joining(" "));
    }

    private String makeNameFormatted(String name) {
        if (name.length() == 5) {
            return name;
        }
        int trailingSpaces = 1;
        int leadingSpaces = MAX_NAME_LENGTH - name.length() - trailingSpaces;
        return " ".repeat(leadingSpaces) + name + " ".repeat(trailingSpaces);
    }

    private String makeLadderFormatted(Ladder ladder) {
        return ladder.getLadder().stream()
                .map(this::makeLineFormatted)
                .collect(Collectors.joining("\n"));
    }

    private String makeLineFormatted(Line line) {
        return line.getPoints().stream()
                .map(point -> point.repeatSymbol(MAX_NAME_LENGTH))
                .collect(Collectors.joining("|", "    |", "|"));
    }
}
