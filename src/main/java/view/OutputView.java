package view;

public class OutputView {
    private static final String LADDER_PREFIX_MESSAGE = "사다리 결과";
    private static final String RESULT_PREFIX_MESSAGE = "실행 결과";

    public void printLadderResultPrefix() {
        System.out.println(LADDER_PREFIX_MESSAGE);
        System.out.println(System.lineSeparator());
    }

    public void printError(Exception exception) {
        printErrorMessage(exception.getMessage());
    }

    private void printErrorMessage(String message) {
        System.out.println(message);
    }


    public void printPlayerResult(String resultContent) {
        System.out.println(LADDER_PREFIX_MESSAGE);
        System.out.println(resultContent);
    }

    public void printAllResultPrefix() {
        System.out.println(RESULT_PREFIX_MESSAGE);
    }

    public void printFormat(String format) {
        System.out.println(format);
    }
}
