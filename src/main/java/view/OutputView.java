package view;

import domain.Direction;
import domain.Ladder;
import domain.Name;

import domain.Row;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_LEFT_MARGIN = "     |";
    private static final String RUNG_EXIST = "-----";
    private static final String RUNG_EMPTY = "     ";
    private static final String RUNG_SEPARATOR = "|";

    public static void printResult(final List<Name> names, final Ladder ladder, final int height) {
        System.out.println("실행 결과\n");

        printPlayers(names);
    }

    public static void printLadder(List<Row> rows) {
        String ladderMessage = rows.stream()
                .map(OutputView::rowToMessage)
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(ladderMessage);
    }

    public static String rowToMessage(Row row) {
        return LADDER_LEFT_MARGIN + row.getRow().stream()
                .map(OutputView::directionToMessage)
                .collect(Collectors.joining(RUNG_SEPARATOR)).concat(RUNG_SEPARATOR);
    }

    private static String directionToMessage(Direction direction) {
        if (direction == Direction.RIGHT) {
            return RUNG_EXIST;
        }
        return RUNG_EMPTY;
    }

    private static void printPlayers(final List<Name> names) {
        for (Name name : names) {
            System.out.printf("%6s", name.name());
        }
        System.out.println();
    }
}
