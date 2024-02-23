package view;

import domain.Ladder;
import domain.Line;
import domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LADDER_LEFT_SIDE = "     |";
    private static final String BRIDGE_EXIST = "-----|";
    private static final String BRIDGE_EMPTY = "     |";


    public static void printResult(final List<Name> names, final Ladder ladder) {
        System.out.println("실행 결과\n");

        printPlayers(names);
        printLadder(ladder);
    }

    private static void printPlayers(final List<Name> names) {
        System.out.println(joinNames(names));
    }

    private static String joinNames(final List<Name> names) {
        return names.stream()
                .map(name -> String.format("%6s", name.name()))
                .collect(Collectors.joining());
    }

    private static void printLadder(final Ladder ladder) {
        ladder.getLines().forEach(line -> {
            System.out.print(LADDER_LEFT_SIDE);
            System.out.println(joinSingleLine(line));
        });
    }

    private static String joinSingleLine(final Line line) {
        return line.getBridges().stream()
                .map(OutputView::getBridgeSymbol)
                .collect(Collectors.joining());
    }

    private static String getBridgeSymbol(Boolean bridge) {
        if (bridge) {
            return BRIDGE_EXIST;
        }
        return BRIDGE_EMPTY;
    }
}
