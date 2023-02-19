package view;

import domain.ladder.Ladder;
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

    public void showResultMessage() {
        System.out.println(RESULT_SHOW_MESSAGE);
    }

    public void showPlayers(List<Player> players) {
        players.forEach(player -> printMessageFormat(player.getName(), PLAYER_SHOW_FORMAT));
        System.out.println();
    }

    public void showLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            List<Boolean> bridges = line.getBridges();
            showBridges(bridges);
            System.out.println();
        }
    }

    private void showBridges(List<Boolean> bridges) {
        System.out.printf(LINE_SPACE_MESSAGE + LINE_BAR_MESSAGE);
        for (Boolean bridge : bridges) {
            printMessageFormat(draw(bridge) + LINE_BAR_MESSAGE, BRIDGE_SHOW_FORMAT);
        }
    }

    private void printMessageFormat(String playerName, String format) {
        System.out.printf(format, playerName);
    }

    private String draw(Boolean bridge) {
        if (bridge) {
            return BRIDGE_TRUE;
        }
        return BRIDGE_FALSE;
    }
}
