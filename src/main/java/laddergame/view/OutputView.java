package laddergame.view;

import laddergame.domain.Line;
import laddergame.domain.Point;

import java.util.List;

public class OutputView {

    private static final String PLAYER_NAMES_REQUEST_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) ";
    private static final String LADDER_HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_INFO_MSG = "실행결과";
    private static final String PLAYER_NAME_FORMAT = "%6s";
    private static final String LADDER_FORMAT = "%s|";

    public static void printPlayerNamesRequestMsg() {
        System.out.println(PLAYER_NAMES_REQUEST_MSG);
    }

    public static void printLadderHeightRequestMsg() {
        System.out.println(LADDER_HEIGHT_MSG);
    }

    public static void printResultInfoMsg() {
        System.out.println(RESULT_INFO_MSG);
    }

    public static void printPlayerNames(List<String> playerNames) {
        for (String name : playerNames) {
            System.out.print(String.format(PLAYER_NAME_FORMAT, name));
        }
        System.out.println();
    }

    public static void printLadderMap(List<Line> ladder) {
        for (Line line : ladder) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(LADDER_FORMAT, Point.DISCONNECT.getDisplayFormat()));
        for (Point point : line.getLine()) {
            stringBuilder.append(String.format(LADDER_FORMAT, point.getDisplayFormat()));
        }
        System.out.println(stringBuilder);
    }

    public static void printErrorMsg(String errorMessage) {
        System.out.println(errorMessage);
    }
}
