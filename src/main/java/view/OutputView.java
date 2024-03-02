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

    public void printLadderGame(final Players players, final Ladder ladder, final Prizes prizes) {
        System.out.println(lineSeparator() + "실행 결과");
        printPlayers(players.getMembers());
        printLadder(ladder);
        printPrizes(prizes.items());
    }

    private void printPlayers(final List<Player> players) {
        System.out.println(makePlayersNameMessage(players));
    }

    private String makePlayersNameMessage(final List<Player> players) {
        return players.stream()
                .map(player -> String.format("%6s", player.name()))
                .collect(Collectors.joining());
    }

    private void printLadder(final Ladder ladder) {
        ladder.getRows().stream()
                .map(this::makeLineMessage)
                .forEach(System.out::println);
    }

    private String makeLineMessage(final Row row) {
        return BRIDGE_LEFT_MARGIN +
                row.getBridges().stream()
                        .map(this::makeBridgeMessage)
                        .collect(Collectors.joining(BRIDGE_SEPARATOR, BRIDGE_SEPARATOR, BRIDGE_SEPARATOR));
    }

    private String makeBridgeMessage(final Bridge bridge) {
        return getBridgeSymbol(bridge).repeat(SINGLE_BRIDGE_LENGTH);
    }

    private String getBridgeSymbol(final Bridge bridge) {
        if (bridge.isExist()) {
            return BRIDGE_EXIST_SYMBOL;
        }
        return BRIDGE_EMPTY_SYMBOL;
    }

    private void printPrizes(final List<Prize> prizes) {
        System.out.println(makePrizesNameMessage(prizes));
    }

    private String makePrizesNameMessage(final List<Prize> prizes) {
        return prizes.stream()
                .map(prize -> String.format("%6s", prize.name()))
                .collect(Collectors.joining());
    }

    public void printSearchResult(final Map<Player, Prize> result) {
        System.out.println(lineSeparator() + "실행 결과");
        if (result.entrySet().size() == 1) {
            printResultOne(result);
            return;
        }
        printResultMulti(result);
    }

    private void printResultOne(final Map<Player, Prize> results) {
        for (Map.Entry<Player, Prize> result : results.entrySet()) {
            System.out.println(result.getValue().name());
        }
    }

    private void printResultMulti(final Map<Player, Prize> results) {
        for (Map.Entry<Player, Prize> result : results.entrySet()) {
            final String name = result.getKey().name();
            final String prize = result.getValue().name();
            System.out.println(name + " : " + prize);
        }
    }

    public void printErrorMessage(final Exception e) {
        System.out.println(e.getMessage() + lineSeparator());
    }
}
