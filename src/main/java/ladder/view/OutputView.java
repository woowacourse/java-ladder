package ladder.view;


import java.util.List;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printPlayerNames(List<String> playerNames) {
        playerNames.stream().forEach(name -> System.out.print(String.format("%-6s", name)));
    }

    public void printRow(List<Boolean> points) {
        System.out.println();
        System.out.print(LadderMark.COLUMN_LINE.getMark());
        for (boolean point : points) {
            System.out.print(LadderMark.getRowMark(point));
            System.out.print(LadderMark.COLUMN_LINE.getMark());
        }
    }

    private enum LadderMark {
        ROW_LINE("-----"),
        ROW_EMPTY("     "),
        COLUMN_LINE("|");
        private final String mark;

        LadderMark(String mark) {
            this.mark = mark;
        }

        public String getMark() {
            return mark;
        }

        public static String getRowMark(boolean hasLine) {
            if (hasLine) return ROW_LINE.mark;
            return ROW_EMPTY.mark;
        }
    }
}
