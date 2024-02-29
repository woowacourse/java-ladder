package view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.bridge.Bridge;
import model.line.LineState;
import model.player.Player;
import model.prize.Prize;

public class OutputView {
    private static final String LADDER_INTRO = "\n사다리 결과\n";
    private static final String NAMES_FORMAT = "%" + Player.MAX_LENGTH_OF_NAME + "s";
    private static final String NAMES_DELIMITER = " ";
    private static final int BRIDGE_LENGTH = Player.MAX_LENGTH_OF_NAME;
    private static final String IS_CONNECTED_BRIDGE = "-";
    private static final String IS_UNCONNECTED_BRIDGE = " ";
    private static final String BRIDGE_DELIMITER = "|";
    private static final String BRIDGE_PREFIX = "    |";
    private static final String EXCEPTION_PREFIX = "[ERROR] ";
    private static final String LADDER_PLAY_OUTCOME_INTRO = "\n실행 결과";
    private static final String LADDER_PLAY_OUTCOME_DELIMITER = " : ";

    private OutputView() {
    }

    public static void printLadderIntro() {
        System.out.println(LADDER_INTRO);
    }

    public static void printPlayerNames(List<String> names) {
        System.out.println(formatNames(names));
    }

    public static void printPrizeNames(List<String> names) {
        System.out.println(formatNames(names));
    }

    public static String formatNames(List<String> names) {
        return names.stream()
                .map(name -> String.format(NAMES_FORMAT, name))
                .collect(Collectors.joining(NAMES_DELIMITER));
    }

    public static void printLadderLines(List<LineState> lines) {
        for (LineState line : lines) {
            List<Bridge> bridges = line.bridges();
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

    public static void printLadderPlayOutcomeIntro() {
        System.out.println(LADDER_PLAY_OUTCOME_INTRO);
    }

    public static void printPrizeForAllPlayers(Map<Player, Prize> outcome) {
        outcome.forEach((player, prize) ->
                System.out.println(formatLadderPlayOutcome(player, prize))
        );
    }

    private static String formatLadderPlayOutcome(Player player, Prize prize) {
        return player.getName() + LADDER_PLAY_OUTCOME_DELIMITER + prize.getName();
    }

    public static void printPrizeForOnePlayer(Prize prize) {
        System.out.println(prize.getName());
    }

    public static void printExceptionMessage(String message) {
        System.out.println(EXCEPTION_PREFIX + message);
    }
}
