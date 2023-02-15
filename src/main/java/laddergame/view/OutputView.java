package laddergame.view;

public class OutputView {

    private static final String PLAYER_NAMES_REQUEST_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) ";
    private static final String LADDER_HEIGHT_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) ";
    private static final String RESULT_INFO_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) ";

    public static void printPlayerNamesRequestMsg() {
        System.out.println(PLAYER_NAMES_REQUEST_MSG);
    }

    public static void printLadderHeightRequestMsg() {
        System.out.println(LADDER_HEIGHT_MSG);
    }

    public static void printResultInfoMsg() {
        System.out.println(RESULT_INFO_MSG);
    }
}
