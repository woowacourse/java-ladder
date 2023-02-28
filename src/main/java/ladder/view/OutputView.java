package ladder.view;

public class OutputView {

    private static final String PLAYER_NAMES_READ_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT_READ_MESSAGE = System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULTS_READ_MESSAGE = System.lineSeparator() + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String WANT_TO_SEE_WHOM_MESSAGE = System.lineSeparator() + "결과를 보고 싶은 사람은?";
    private static final String RESULT_AFTER_EXECUTION_MESSAGE = System.lineSeparator() + "실행 결과";

    public static void printPlayerNamesReadMessage() {
        printMessage(PLAYER_NAMES_READ_MESSAGE);
    }

    public static void printMaxLadderHeightReadMessage() {
        printMessage(MAX_LADDER_HEIGHT_READ_MESSAGE);
    }

    public static void printResultsReadMessage() {
        printMessage(RESULTS_READ_MESSAGE);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printWantToSeeWhomMessage() {
        printMessage(WANT_TO_SEE_WHOM_MESSAGE);
    }

    public static void printResultAfterExecutionMessage() {
        printMessage(RESULT_AFTER_EXECUTION_MESSAGE);
    }
}
