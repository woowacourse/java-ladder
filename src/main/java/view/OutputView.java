package view;

import domain.ladder.Bridge;
import domain.ladder.Line;
import domain.player.Player;

import java.util.List;

public class OutputView {

    private static final String RESULT_SHOW_MESSAGE = "실행결과";
    private static final String BRIDGE_TRUE = "-----";
    private static final String BRIDGE_FALSE = "     ";
    private static final String LINE_BAR_MESSAGE = "|";
    private static final String LINE_SPACE_MESSAGE = "    ";
    private static final String PLAYER_SHOW_FORMAT = "%5s ";
    private static final String BRIDGE_SHOW_FORMAT = "%s";
    private static final String ITEM_SHOW_FORMAT = "%5s ";

    public void showResultMessage() {
        System.out.println(RESULT_SHOW_MESSAGE);
    }

    public void showPlayers(List<Player> players) {
        players.forEach(player -> printMessageFormat(player.getName(), PLAYER_SHOW_FORMAT));
        System.out.println();
    }

    public void showLadder(List<Line> lines) {
        for (Line line : lines) {
            List<Bridge> bridges = line.getBridges();
            showBridges(bridges);
            System.out.println();
        }
    }

    public void showItems(List<String> items) {
        items.forEach(item -> printMessageFormat(item, ITEM_SHOW_FORMAT));
    }

    private void showBridges(List<Bridge> bridges) {
        System.out.printf(LINE_SPACE_MESSAGE + LINE_BAR_MESSAGE);
        for (Bridge bridge : bridges) {
            printMessageFormat(draw(bridge) + LINE_BAR_MESSAGE, BRIDGE_SHOW_FORMAT);
        }
    }

    private void printMessageFormat(String playerName, String format) {
        System.out.printf(format, playerName);
    }

    private String draw(Bridge bridge) {
        if (bridge.isPassable()) {
            return BRIDGE_TRUE;
        }
        return BRIDGE_FALSE;
    }
}
