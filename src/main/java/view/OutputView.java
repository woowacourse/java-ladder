package view;

import java.util.List;
import java.util.stream.Collectors;
import model.Ladder;
import model.Line;
import model.Player;
import model.Players;

public class OutputView {
    private static final String PLAYER_NAMES_FORMAT = "%" + Player.MAX_LENGTH_OF_NAME + "s";
    private static final String PLAYER_NAMES_DELIMITER = " ";
    private static final int BRIDGE_LENGTH = Player.MAX_LENGTH_OF_NAME;
    private static final String IS_CONNECTED_BRIDGE = "-";
    private static final String IS_UNCONNECTED_BRIDGE = " ";
    private static final String BRIDGE_DELIMITER = "|";
    private static final String BRIDGE_PREFIX = "    |";

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
            List<Boolean> bridges = line.getBridges();
            String result = bridges.stream()
                    .map(OutputView::formatBridge)
                    .collect(Collectors.joining(BRIDGE_DELIMITER));
            System.out.println(BRIDGE_PREFIX + result + BRIDGE_DELIMITER);
        }
    }

    private static String formatBridge(Boolean isConnected) {
        if (isConnected) {
            return IS_CONNECTED_BRIDGE.repeat(BRIDGE_LENGTH);
        }
        return IS_UNCONNECTED_BRIDGE.repeat(BRIDGE_LENGTH);
    }
}
