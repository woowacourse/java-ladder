package ladder.view;

import ladder.domain.LadderResult;
import ladder.domain.item.LadderItems;
import ladder.domain.item.Person;
import ladder.domain.item.WinningItem;
import ladder.domain.ladder.Connection;
import ladder.domain.ladder.Ladder;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {
    private static final String LADDER_RESULT = "사다리 결과" + System.lineSeparator();
    private static final String ITEM_NAMES_DELIMITER = " ";
    private static final String LADDER_FORMAT = String.format("%%%ds", Person.getMaxLength());
    private static final String LINE_PILLAR = "|";
    private static final String LINE_PREFIX = String.format(LADDER_FORMAT, LINE_PILLAR);
    private static final String LADDER_RANG = "-".repeat(Person.getMaxLength());
    private static final String LADDER_EMPTY = " ".repeat(Person.getMaxLength());
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String TOTAL_RESULT_FORMAT = "%s : %s";
    private static final Map<Connection, String> CONNECTION_FORMAT = new EnumMap<>(Connection.class);

    static {
        CONNECTION_FORMAT.put(Connection.RUNG, LADDER_RANG);
        CONNECTION_FORMAT.put(Connection.EMPTY, LADDER_EMPTY);
    }

    public void printLadder(LadderItems ladderItems, Ladder ladder) {
        printResultTitle();
        printItemNames(ladderItems.getPeopleNames());
        printLadder(ladder);
        printItemNames(ladderItems.getWinningItemNames());
        System.out.println();
    }

    private void printResultTitle() {
        System.out.println(LADDER_RESULT);
    }

    private void printItemNames(List<String> itemNames) {
        StringJoiner joiner = new StringJoiner(ITEM_NAMES_DELIMITER);
        for (String itemName : itemNames) {
            joiner.add(String.format(LADDER_FORMAT, itemName));
        }

        System.out.println(joiner);
    }

    private void printLadder(Ladder ladder) {
        ladder.getConnections().forEach(this::printConnections);
    }

    private void printConnections(List<Connection> connections) {
        StringJoiner joiner = new StringJoiner(LINE_PILLAR, LINE_PREFIX, LINE_PILLAR);
        for (Connection connection : connections) {
            joiner.add(CONNECTION_FORMAT.get(connection));
        }

        System.out.println(joiner);
    }

    public void printResultOfPerson(WinningItem winningItem) {
        System.out.println(EXECUTION_RESULT);
        System.out.println(winningItem.getName());
        System.out.println();
    }

    public void printTotalResult(LadderResult ladderResult) {
        System.out.println(EXECUTION_RESULT);
        ladderResult.getTotalResult().entrySet().forEach(entry ->
                System.out.println(String.format(TOTAL_RESULT_FORMAT, entry.getKey(), entry.getValue())));
    }
}
