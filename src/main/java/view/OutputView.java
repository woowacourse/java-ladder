package view;

import domain.Line;
import domain.Lines;
import domain.Name;
import domain.Names;
import domain.Result;
import domain.Reward;
import domain.Rewards;

public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printLines(Names names, Lines lines, Rewards rewards) {
        System.out.println(Message.OUTPUT_LINES_MESSAGE.message);
        printEachName(names);
        printEachLine(lines);
        printEachReward(rewards);
    }

    private void printEachName(Names names) {
        for (Name name : names.getNames()) {
            System.out.printf(Message.STRING_FORMAT.message, name.getName());
        }
        System.out.println();
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

    private void printEachReward(Rewards rewards) {
        for (Reward reward : rewards.getRewards()) {
            System.out.printf(Message.STRING_FORMAT.message, reward.getReward());
        }
        System.out.println();
    }

    private String getPointString(boolean isPoint) {
        if (isPoint) {
            return Message.ROW_LADDER.message;
        }
        return Message.EMPTY_ROW_LADDER.message;
    }

    public void printResult(String name, Names names, Result result) {
        System.out.println();
        System.out.println(Message.OUTPUT_RESULT_MESSAGE.message);
        for (Name nameObj : names.getNames()) {
            printOrPass(name, result, nameObj);
        }
    }

    private void printOrPass(String name, Result result, Name nameObj) {
        if (isPrint(name, nameObj)) {
            System.out.printf("%s : %s\n", nameObj.getName(), result.getReward(nameObj).getReward());
        }
    }

    private boolean isPrint(String name, Name nameObj) {
        return name.equals(nameObj.getName()) || name.equals("all");
    }

    private enum Message {
        OUTPUT_LINES_MESSAGE("사다리 결과"),
        OUTPUT_RESULT_MESSAGE("실행 결과"),
        STRING_FORMAT("%-6s"),
        COLUMN_LADDER("  |"),
        ROW_LADDER("-----|"),
        EMPTY_ROW_LADDER("     |");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
