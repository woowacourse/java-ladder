package ladder.view;

public class OutputView {

    private static final String PLAYER_NAMES_READ_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT_READ_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String EXECUTION_MESSAGE = "실행결과";

    public static void printPlayerNamesReadMessage() {
        printMessage(PLAYER_NAMES_READ_MESSAGE);
    }

    public static void printMaxLadderHeightReadMessage() {
        printMessage(MAX_LADDER_HEIGHT_READ_MESSAGE);
    }

    public static void printExecutionMessage() {
        printMessage(EXECUTION_MESSAGE);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
