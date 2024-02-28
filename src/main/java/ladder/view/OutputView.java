package ladder.view;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public static void printNewLine() {
        System.out.println();
    }

}
