package view;

import java.util.List;
import java.util.stream.Collectors;
import model.bridge.Bridge;
import model.ladder.Ladder;
import model.line.Line;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;

public class OutputView {
    private static final String LADDER_RESULT_INTRO = "\n사다리 결과\n";
    private static final String GAME_RESULT_INTRO = "\n실행 결과";
    private static final int BRIDGE_LENGTH = 5;
    private static final String NAMES_FORMAT = "%" + BRIDGE_LENGTH + "s";
    private static final String NAMES_DELIMITER = " ";
    private static final String IS_CONNECTED_BRIDGE = "-";
    private static final String IS_UNCONNECTED_BRIDGE = " ";
    private static final String BRIDGE_DELIMITER = "|";
    private static final String BRIDGE_PREFIX = "    |";
    private static final String EXCEPTION_PREFIX = "[ERROR] ";

    private OutputView() {
    }

    public static void printLadderResultIntro() {
        System.out.println(LADDER_RESULT_INTRO);
    }

    public static void printPlayerNames(Players players) {
        List<String> names = players.getNames()
                .stream()
                .map(name -> String.format(NAMES_FORMAT, name))
                .toList();
        String result = String.join(NAMES_DELIMITER, names);
        System.out.println(result);
    }

    public static void printPrizeNames(Prizes prizes) {
        List<String> names = prizes.getNames()
                .stream()
                .map(name -> String.format(NAMES_FORMAT, name))
                .toList();
        String result = String.join(NAMES_DELIMITER, names);
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

    public static void printGameResult(Prize prize) {
        System.out.println(GAME_RESULT_INTRO);
        System.out.println(prize.getName());
    }

    public static void printExceptionMessage(String message) {
        System.out.println(EXCEPTION_PREFIX + message);
    }
}
