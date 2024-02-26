package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.People;

import java.util.StringJoiner;
import java.util.stream.Collectors;

import static java.lang.System.lineSeparator;

public class OutputView {

    public void printError(String message) {
        System.out.println(message);
    }

    public void printPeople(People people) {
        StringJoiner resultNotice = new StringJoiner("실행결과", lineSeparator(), lineSeparator());
        System.out.println(resultNotice);

        String nameFormat = makeNameFormat(people);

        for (String name : people.getNames()) {
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
        String points = line.getPoints().stream()
                .map(point -> point.repeatSymbol(maxNameLength))
                .collect(Collectors.joining("|", "    |", "|"));
        System.out.println(points);
    }
}
