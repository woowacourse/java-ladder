package laddergame.view;

import laddergame.domain.Line;
import laddergame.domain.Point;

import java.util.List;

public class OutputView {

    private static final int LADDER_SPACING = 5;
    private static final int NAME_SPACING = LADDER_SPACING + 1;
    private static final String PLAYER_NAMES_REQUEST_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) ";
    private static final String PRIZES_REQUEST_MSG = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요) ";
    private static final String LADDER_HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";
    private static final String PLAYER_NAME_FOR_RESULT_REQUEST_MSG = "결과를 보고 싶은 사람은?";

    private static final String LADDER_RESULT_MSG = "사다리 결과";

    private static final String RESULT_INFO_MSG = "실행 결과";
    private static final String PLAYER_NAME_FORMAT = "%" + NAME_SPACING + "s";
    private static final String LADDER_FORMAT = "%s|";

    private OutputView() {
    }

    public static void printPlayerNamesRequestMsg() {
        System.out.println(PLAYER_NAMES_REQUEST_MSG);
    }

    public static void printPrizesRequestMsg() {
        System.out.println(PRIZES_REQUEST_MSG);
    }

    public static void printLadderHeightRequestMsg() {
        System.out.println(LADDER_HEIGHT_MSG);
    }

    public static void printLadderResultMsg() {
        System.out.println(LADDER_RESULT_MSG);
    }

    public static void printResultInfoMsg() {
        System.out.println(RESULT_INFO_MSG);
    }

    public static void printPlayerNames(List<String> playerNames) {
        playerNames.forEach((playerName) ->
                System.out.printf(PLAYER_NAME_FORMAT, playerName)
        );
        System.out.println();
    }

    public static void printPrizeNames(List<String> prizeNames) {
        prizeNames.forEach((prizeName) ->
                System.out.printf(PLAYER_NAME_FORMAT, prizeName)
        );
        System.out.println();
    }

    public static void printLadderMap(List<Line> ladder) {
        ladder.forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(LADDER_FORMAT, Point.DISCONNECT.getDisplayFormat(LADDER_SPACING)));
        line.getLine().forEach((point) ->
                stringBuilder.append(String.format(LADDER_FORMAT, point.getDisplayFormat(LADDER_SPACING)))
        );
        System.out.println(stringBuilder);
    }

    public static void printPlayerNameForResult() {
        System.out.println(PLAYER_NAME_FOR_RESULT_REQUEST_MSG);
    }

    public static void printErrorMsg(String errorMessage) {
        System.out.println(errorMessage);
    }
}
