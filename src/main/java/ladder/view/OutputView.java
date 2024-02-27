package ladder.view;

import ladder.domain.Connection;
import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.domain.Person;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {
    private static final String EXECUTION_RESULT = "실행결과" + System.lineSeparator();
    private static final String PEOPLE_NAMES_DELIMITER = " ";
    private static final String LADDER_FORMAT = String.format("%%%ds", Person.getMaxLength());
    private static final String LINE_PILLAR = "|";
    private static final String LINE_PREFIX = String.format(LADDER_FORMAT, LINE_PILLAR);
    private static final String LADDER_RANG = "-".repeat(Person.getMaxLength());
    private static final String LADDER_EMPTY = " ".repeat(Person.getMaxLength());
    private static final Map<Connection, String> CONNECTION_FORMAT = new EnumMap<>(Connection.class);

    static {
        CONNECTION_FORMAT.put(Connection.RUNG, LADDER_RANG);
        CONNECTION_FORMAT.put(Connection.EMPTY, LADDER_EMPTY);
    }

    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printResult(People people, Ladder ladder) {
        printResultTitle();
        printPeopleNames(people);
        printLadder(ladder);
    }

    private static void printResultTitle() {
        System.out.println(EXECUTION_RESULT);
    }

    private static void printPeopleNames(People people) {
        StringJoiner joiner = new StringJoiner(PEOPLE_NAMES_DELIMITER);
        for (String name : people.getNames()) {
            joiner.add(String.format(LADDER_FORMAT, name));
        }

        System.out.println(joiner);
    }

    private static void printLadder(Ladder ladder) {
        ladder.getConnections().forEach(OutputView::printConnections);
    }

    private static void printConnections(List<Connection> connections) {
        StringJoiner joiner = new StringJoiner(LINE_PILLAR, LINE_PREFIX, LINE_PILLAR);
        for (Connection connection : connections) {
            joiner.add(CONNECTION_FORMAT.get(connection));
        }

        System.out.println(joiner);
    }
}
