package ladder.view;


import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String OUTPUT_ALL_PLAYER_RESULT_FORMAT = "%s : %s\n";
    private static final String OUTPUT_WORD_FORMAT = "%-6s";
    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printPlayerNames(List<String> playerNames) {
        playerNames.forEach(name -> System.out.printf(OUTPUT_WORD_FORMAT, name));
    }

    public void printLadderResultMessage() {
        System.out.println();
        System.out.println(OutputMessage.OUTPUT_LADDER_RESULT.getMessage());
    }

    public void printRow(List<Boolean> points) {
        System.out.println();
        System.out.print(LadderMark.COLUMN_LINE.getMark());
        for (boolean point : points) {
            System.out.print(LadderMark.getRowMark(point));
            System.out.print(LadderMark.COLUMN_LINE.getMark());
        }
    }

    public void printRewards(List<String> results) {
        System.out.println();
        results.forEach(result -> System.out.printf(OUTPUT_WORD_FORMAT, result));
        System.out.println();
    }

    public void printChosePlayerResult(String result) {
        System.out.println(OutputMessage.OUTPUT_EXECUTION_RESULT.getMessage());
        System.out.println(result);
    }

    public void printAllPlayerResults(Map<String, String> matchingResults) {
        System.out.println(OutputMessage.OUTPUT_EXECUTION_RESULT.getMessage());
        matchingResults.forEach((key, value) -> System.out.printf(OUTPUT_ALL_PLAYER_RESULT_FORMAT, key, value));
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    private enum LadderMark {
        ROW_LINE("-----"),
        ROW_EMPTY("     "),
        COLUMN_LINE("|");
        private final String mark;

        LadderMark(String mark) {
            this.mark = mark;
        }

        private String getMark() {
            return mark;
        }

        private static String getRowMark(boolean hasLine) {
            if (hasLine) return ROW_LINE.mark;
            return ROW_EMPTY.mark;
        }
    }

    private enum OutputMessage {

        OUTPUT_LADDER_RESULT("사다리 결과"),
        OUTPUT_EXECUTION_RESULT("실행 결과");

        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

    }

}
