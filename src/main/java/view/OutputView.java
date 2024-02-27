package view;

import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import domain.ladder.Bridge;
import domain.ladder.Ladder;
import domain.ladder.Row;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.lineSeparator;

public class OutputView {
    private static final int SINGLE_BRIDGE_LENGTH = 5;
    private static final String BRIDGE_SEPARATOR = "|";
    private static final String BRIDGE_LEFT_MARGIN = "     ";
    private static final String BRIDGE_EXIST_SYMBOL = "-";
    private static final String BRIDGE_EMPTY_SYMBOL = " ";

    public static void printLadderGame(final Players players, final Ladder ladder, final Prizes prizes) {
        System.out.println(lineSeparator() + "실행 결과");
        printPlayers(players.players());
        printLadder(ladder);
        printPrizes(prizes.prizes());
    }

    private static void printPlayers(final List<Player> players) {
        System.out.println(makePlayersNameMessage(players));
    }

    private static String makePlayersNameMessage(final List<Player> players) {
        return players.stream()
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
        if (bridge.isExist()) {
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

    public static void printSearchResult(final Map<Player, Prize> result) {
        System.out.println(lineSeparator() + "실행 결과");
        if (result.entrySet().size() == 1) {
            printResultOne(result);
            return;
        }
        printResultMulti(result);
    }

    private static void printResultOne(Map<Player, Prize> results) {
        for (Map.Entry<Player, Prize> result : results.entrySet()) {
            System.out.println(result.getValue().name());
        }
    }

    private static void printResultMulti(Map<Player, Prize> results) {
        for (Map.Entry<Player, Prize> result : results.entrySet()) {
            final String name = result.getKey().name();
            final String prize = result.getValue().name();
            System.out.println(name + " : " + prize);
        }
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage() + lineSeparator());
    }
}
