package view;

import domain.Line;
import domain.Lines;
import domain.Name;
import domain.Names;
import domain.Result;

public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printLines(Names names, Lines lines) {
        System.out.println(Message.OUTPUT_RESULT.message);
        names.getNames()
                .forEach(name -> System.out.printf(Message.NAME_FORMAT.message, name.getName()));
        System.out.println();
        printEachLine(lines);
    }

    private void printEachLine(Lines lines) {
        for (Line line : lines.getLines()) {
            StringBuilder result = new StringBuilder();
            result.append(Message.COLUMN_LADDER.message);
            line.getLine()
                    .forEach(isPoint -> result.append(getPointString(isPoint)));
            System.out.println(result);
        }
    }

    private String getPointString(boolean isPoint) {
        if (isPoint) {
            return Message.ROW_LADDER.message;
        }
        return Message.EMPTY_ROW_LADDER.message;
    }

    public void printResult(String name, Names names, Result result) {
        System.out.println();
        System.out.println("실행결과");
        for (Name nameObj : names.getNames()) {
            printOrPass(name, result, nameObj);
        }
    }

    private void printOrPass(String name, Result result, Name nameObj) {
        if (isPrint(name, nameObj)) {
            System.out.println(result.getReward(nameObj).getReward());
        }
    }

    private boolean isPrint(String name, Name nameObj) {
        return name.equals(nameObj.getName()) || name.equals("all");
    }

    private enum Message {
        OUTPUT_RESULT("실행결과\n"),
        NAME_FORMAT("%-6s"),
        COLUMN_LADDER("  |"),
        ROW_LADDER("-----|"),
        EMPTY_ROW_LADDER("     |");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
