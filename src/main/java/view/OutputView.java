package view;

import java.util.List;
import java.util.stream.Collectors;
import model.bridge.Bridge;
import model.gameresult.GameResult;
import model.ladder.Ladder;
import model.line.Line;
import model.player.Player;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;

public class OutputView {

    private static final String LADDER_RESULT_INTRO = "사다리 결과";
    private static final String GAME_RESULT_INTRO = "실행 결과";
    private static final int BRIDGE_LENGTH = 5;
    private static final String NAMES_FORMAT = "%" + BRIDGE_LENGTH + "s";
    private static final String NAMES_DELIMITER = " ";
    private static final String IS_CONNECTED_BRIDGE = "-";
    private static final String IS_UNCONNECTED_BRIDGE = " ";
    private static final String BRIDGE_DELIMITER = "|";
    private static final String BRIDGE_PREFIX = "    |";
    private static final String GAME_RESULT_FORMAT = "%s : %s";
    private static final String EXCEPTION_PREFIX = "[ERROR] ";
    private static final String SEARCH_ALL = "all";
    private static final String NEWLINE = System.lineSeparator();

    private OutputView() {
    }

    public static void printLadderResult(Players players, Ladder ladder, Prizes prizes) {
        System.out.println(NEWLINE + LADDER_RESULT_INTRO + NEWLINE);
        printPlayerNames(players);
        printLadder(ladder);
        printPrizeNames(prizes);
    }

    private static void printPlayerNames(Players players) {
        List<String> names = players.getNames()
            .stream()
            .map(name -> String.format(NAMES_FORMAT, name))
            .toList();
        String result = String.join(NAMES_DELIMITER, names);
        System.out.println(result);
    }

    private static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            List<Bridge> bridges = line.getBridges();
            String result = bridges.stream()
                .map(OutputView::formatBridge)
                .collect(Collectors.joining(BRIDGE_DELIMITER));
            System.out.println(BRIDGE_PREFIX + result + BRIDGE_DELIMITER);
        }
    }

    private static String formatBridge(Bridge bridge) {
        if (bridge.isConnected()) {
            return IS_CONNECTED_BRIDGE.repeat(BRIDGE_LENGTH);
        }
        return IS_UNCONNECTED_BRIDGE.repeat(BRIDGE_LENGTH);
    }

    private static void printPrizeNames(Prizes prizes) {
        List<String> names = prizes.getNames()
            .stream()
            .map(name -> String.format(NAMES_FORMAT, name))
            .toList();
        String result = String.join(NAMES_DELIMITER, names);
        System.out.println(result);
    }

    public static void printSearchingResult(String playerName, GameResult gameResult) {
        if (playerName.equals(SEARCH_ALL)) {
            printGameResultAll(gameResult);
            return;
        }
        printGameResult(playerName, gameResult);
    }

    private static void printGameResultAll(GameResult gameResult) {
        System.out.println(NEWLINE + GAME_RESULT_INTRO);
        gameResult.getPlayers()
            .forEach(player -> printPlayerAndPrize(gameResult, player));
    }

    private static void printPlayerAndPrize(GameResult gameResult, Player player) {
        Prize prize = gameResult.findPrizeByPlayer(player);
        System.out.printf(GAME_RESULT_FORMAT + NEWLINE, player.name(), prize.getName());
    }

    private static void printGameResult(String playerName, GameResult gameResult) {
        Prize prize = gameResult.findPrizeByPlayerName(playerName);
        System.out.println(NEWLINE + GAME_RESULT_INTRO + NEWLINE + prize.getName());
    }

    public static void printExceptionMessage(String message) {
        System.out.println(EXCEPTION_PREFIX + message);
    }
}
