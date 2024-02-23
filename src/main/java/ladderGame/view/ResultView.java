package ladderGame.view;

import ladderGame.model.ConnectionStatus;
import ladderGame.model.Line;
import ladderGame.model.Player;

import java.util.List;

public class ResultView {
    private static final String RESULT_PROMPT = "실행 결과";
    private static final String BLANK_MARK = "     ";
    private static final String DISCONNECTION_MARK = "     ";
    private static final String CONNECTION_MARK = "-----";
    private static final String LINE_MARK = "|";

    public void printLadder(List<Player> players, List<Line> lines) {
        System.out.println(System.lineSeparator() + RESULT_PROMPT + System.lineSeparator());

        printPlayerNames(players);
        printLines(lines);
    }

    private void printPlayerNames(List<Player> players) {
        players.forEach(player -> System.out.printf("%6s", player.getName()));
        System.out.println();
    }

    private void printLines(List<Line> lines) {
        lines.forEach(line -> System.out.println(makeLineToString(line)));
    }

    private String makeLineToString(Line line) {
        List<ConnectionStatus> spaces = line.getConnectionStatuses();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(BLANK_MARK + LINE_MARK);
        for (ConnectionStatus space : spaces) {
            stringBuilder.append(makeConnectionStatusToString(space)).append(LINE_MARK);
        }
        return stringBuilder.toString();
    }

    private String makeConnectionStatusToString(ConnectionStatus connectionStatus) {
        if (connectionStatus.equals(ConnectionStatus.CONNECTION)) {
            return CONNECTION_MARK;
        }
        return DISCONNECTION_MARK;
    }
}
