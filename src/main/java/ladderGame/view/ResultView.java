package ladderGame.view;

import ladderGame.model.ConnectionStatus;
import ladderGame.model.Line;
import ladderGame.model.Player;

import java.util.List;
import ladderGame.model.Players;
import ladderGame.model.Result;
import ladderGame.model.Results;

public class ResultView {
    private static final String LADDER_RESULT_PROMPT = "사다리 결과";
    private static final String RESULT_PROMPT = "실행 결과";
    private static final String BLANK_MARK = "     ";
    private static final String DISCONNECTION_MARK = "     ";
    private static final String CONNECTION_MARK = "-----";
    private static final String LINE_MARK = "|";

    public void printLadder(List<Player> players, List<Line> lines, List<Result> results) {
        System.out.println(System.lineSeparator() + LADDER_RESULT_PROMPT + System.lineSeparator());

        players.forEach(player -> System.out.printf("%6s", player.getName()));
        System.out.println();

        lines.forEach(line -> System.out.println(makeLineToString(line)));

        results.forEach(result -> System.out.printf("%6s", result.getResult()));
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

    public void printResult(List<Player> players, List<Result> results) {
        System.out.println("실행 결과");

        for(Player player : players) {
            int index = player.getPosition();
            System.out.printf("%s : %s" + System.lineSeparator(), player.getName(), results.get(index).getResult());
        }
    }
}
