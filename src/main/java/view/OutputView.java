package view;

import domain.Direction;
import domain.Ladder;
import domain.Name;

import domain.Row;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_LEFT_MARGIN = "     |";
    private static final String RUNG_EXIST = "-----";
    private static final String RUNG_EMPTY = "     ";
    private static final String RUNG_SEPARATOR = "|";

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static void printResult(final List<Name> names, final List<Name> results, final Ladder ladder) {
        System.out.println("실행 결과\n");

        printNames(names);
        printLadder(ladder.getRows());
        printNames(results);
    }

    public static void printAllPlayerResult(final List<Name> players, final List<Name> results,
            final Map<Integer, Integer> playerMatchResult) {
        final int width = players.size();

        for (int i = 0; i < width; ++i) {
            int resultIndex = playerMatchResult.get(i);
            final Name player = players.get(i);
            final Name result = results.get(resultIndex);
            System.out.printf("%s : %s\n", player.name(), result.name());
        }
    }

    private static void printNames(final List<Name> names) {
        names.forEach(name -> System.out.printf("%6s", name.name()));
        System.out.println();
    }

    private static void printLadder(List<Row> rows) {
        String ladderMessage = rows.stream()
                .map(OutputView::rowToMessage)
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(ladderMessage);
    }

    private static String rowToMessage(Row row) {
        final int outputSize = row.getRow().size() - 1;
        return LADDER_LEFT_MARGIN + row.getRow().stream()
                .map(OutputView::directionToMessage)
                .limit(outputSize)
                .collect(Collectors.joining(RUNG_SEPARATOR)).concat(RUNG_SEPARATOR);
    }

    private static String directionToMessage(Direction direction) {
        if (direction == Direction.RIGHT) {
            return RUNG_EXIST;
        }
        return RUNG_EMPTY;
    }
}
