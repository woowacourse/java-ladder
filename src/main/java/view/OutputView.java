package view;

import domain.db.Name;
import domain.db.Names;
import domain.db.Prize;
import domain.db.Prizes;
import domain.ladder.Bridge;
import domain.ladder.Ladder;
import domain.ladder.Row;

import java.util.List;
import java.util.stream.Collectors;

import static domain.ladder.Bridge.EXIST;

public class OutputView {
    private static final int SINGLE_BRIDGE_LENGTH = 5;
    private static final String BRIDGE_SEPARATOR = "|";
    private static final String BRIDGE_LEFT_MARGIN = "     ";
    private static final String BRIDGE_EXIST_SYMBOL = "-";
    private static final String BRIDGE_EMPTY_SYMBOL = " ";


    public static void printResult(final Names names, final Ladder ladder, final Prizes prizes) {
        System.out.println(System.lineSeparator() + "실행 결과");
        printPlayers(names.names());
        printLadder(ladder);
        printPrizes(prizes.prizes());
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    private static void printPlayers(final List<Name> names) {
        System.out.println(makePlayersNameMessage(names));
    }

    private static String makePlayersNameMessage(final List<Name> names) {
        return names.stream()
                .map(name -> String.format("%6s", name.name()))
                .collect(Collectors.joining());
    }

    private static void printLadder(final Ladder ladder) {
        ladder.getRows().stream()
                .map(OutputView::makeLineMessage)
                .forEach(System.out::println);
    }

    private static String makeLineMessage(final Row row) {
        return BRIDGE_LEFT_MARGIN +
                row.getBridges().stream()
                        .map(OutputView::makeBridgeMessage)
                        .collect(Collectors.joining(BRIDGE_SEPARATOR, BRIDGE_SEPARATOR, BRIDGE_SEPARATOR));
    }

    private static String makeBridgeMessage(final Bridge bridge) {
        return getBridgeSymbol(bridge).repeat(SINGLE_BRIDGE_LENGTH);
    }

    private static String getBridgeSymbol(final Bridge bridge) {
        if (bridge == EXIST) {
            return BRIDGE_EXIST_SYMBOL;
        }
        return BRIDGE_EMPTY_SYMBOL;
    }

    private static void printPrizes(final List<Prize> prizes) {
        System.out.println(makePrizesNameMessage(prizes));
    }

    private static String makePrizesNameMessage(final List<Prize> prizes) {
        return prizes.stream()
                .map(prize -> String.format("%6s", prize.name()))
                .collect(Collectors.joining());
    }
}
