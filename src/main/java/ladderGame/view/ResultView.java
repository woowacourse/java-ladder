package ladderGame.view;

import ladderGame.model.ConnectionStatus;
import ladderGame.model.Line;
import ladderGame.model.Player;

import java.util.List;
import ladderGame.model.Prize;

public class ResultView {
    private static final String LADDER_RESULT_PROMPT = "사다리 결과";
    private static final String RESULT_PROMPT = "실행 결과";
    private static final String BLANK_MARK = "     ";
    private static final String DISCONNECTION_MARK = "     ";
    private static final String CONNECTION_MARK = "-----";
    private static final String LINE_MARK = "|";

    public void printLadder(List<Player> players, List<Line> lines, List<Prize> prizes) {
        System.out.println(System.lineSeparator() + LADDER_RESULT_PROMPT + System.lineSeparator());

        players.forEach(player -> System.out.printf("%6s", player.getName()));
        System.out.println();

        lines.forEach(line -> System.out.println(makeLineToString(line)));

        prizes.forEach(prize -> System.out.printf("%6s", prize.getPrize()));
        System.out.println();
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

    public void printResult(Player player, List<Prize> prizes) {
        System.out.println(System.lineSeparator() + "실행 결과");

        int index = player.getPosition();
        System.out.printf("%s" + System.lineSeparator(), prizes.get(index).getPrize());
    }

    public void printAllResults(List<Player> players, List<Prize> prizes) {
        System.out.println(System.lineSeparator() + "실행 결과");

        for(Player player : players) {
            int index = player.getPosition();
            System.out.printf("%s : %s" + System.lineSeparator(), player.getName(), prizes.get(index).getPrize());
        }
    }
}
