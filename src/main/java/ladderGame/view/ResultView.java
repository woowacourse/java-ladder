package ladderGame.view;

import ladderGame.model.ConnectionStatus;
import ladderGame.model.Line;
import ladderGame.model.Player;

import java.util.List;
import ladderGame.model.Result;

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

        results.forEach(result -> System.out.printf(convert(result.getResult(), 6)));
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

    public static String convert(String word, int size) {
        String formatter = String.format("%%%ds", size - getKorCnt(word));
        return String.format(formatter, word);
    }

    private static int getKorCnt(String kor) {
        int cnt = 0;
        for (int i = 0 ; i < kor.length() ; i++) {
            if (kor.charAt(i) >= '가' && kor.charAt(i) <= '힣') {
                cnt++;
            }
        }
        return cnt;
    }
}
