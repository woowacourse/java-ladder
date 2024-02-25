package view;

import java.util.List;
import java.util.stream.Collectors;
import model.bridge.Bridge;
import model.ladder.Ladder;
import model.line.Line;
import model.player.Player;
import model.player.Players;

public class OutputView {
    private static final String GAME_RESULT_INTRO = "\n실행결과\n";
    private static final String PLAYER_NAMES_FORMAT = "%" + Player.MAX_LENGTH_OF_NAME + "s";
    private static final String PLAYER_NAMES_DELIMITER = " ";
    private static final int BRIDGE_LENGTH = Player.MAX_LENGTH_OF_NAME;
    private static final String IS_CONNECTED_BRIDGE = "-";
    private static final String IS_UNCONNECTED_BRIDGE = " ";
    private static final String BRIDGE_DELIMITER = "|";
    private static final String BRIDGE_PREFIX = "    |";
    private static final String EXCEPTION_PREFIX = "[ERROR] ";

    private OutputView() {
    }

    public static void printGameResultIntro() {
        System.out.println(GAME_RESULT_INTRO);
    }

    public static void printPlayerNames(Players players) {
        List<String> names = players.getPlayerNames()
                .stream()
                .map((name) -> String.format(PLAYER_NAMES_FORMAT, name))
                .toList();
        String result = String.join(PLAYER_NAMES_DELIMITER, names);
        System.out.println(result);
    }

    public static void printLadder(Ladder ladder) {
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

    public static void printExceptionMessage(String message) {
        System.out.println(EXCEPTION_PREFIX + message);
    }
}
