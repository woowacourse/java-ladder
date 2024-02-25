package ladder.view;

import ladder.domain.Compensation;
import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.domain.RowLine;
import ladder.domain.enums.NameFormat;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String BLANK = " ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-";
    private static final int INTERVAL_WIDTH = 5;

    private OutputView() {
    }

    public static void printPeopleName(People people) {
        printNames(people.getNames());
    }

    public static void printLadder(Ladder ladder) {
        for (RowLine rowLine : ladder.getRowLines()) {
            printRowLine(rowLine);
        }
    }

    public static void printCompensation(Compensation compensation) {
        printNames(compensation.getAll());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printNames(List<String> names) {
        StringJoiner nameJoiner = new StringJoiner(BLANK);

        for (String name : names) {
            String format = NameFormat.findFormat(name.length());
            nameJoiner.add(String.format(format, name));
        }
        System.out.println(nameJoiner);
    }

    private static void printRowLine(RowLine rowLine) {
        StringBuilder stringBuilder = new StringBuilder(
                BLANK.repeat(INTERVAL_WIDTH - 1) + VERTICAL_LINE);

        for (boolean isConnected : rowLine.getConnection()) {
            stringBuilder.append(findConnectionMark(isConnected).repeat(INTERVAL_WIDTH));
            stringBuilder.append(VERTICAL_LINE);
        }
        System.out.println(stringBuilder);
    }

    private static String findConnectionMark(boolean isConnected) {
        if (isConnected) {
            return HORIZONTAL_LINE;
        }
        return BLANK;
    }
}
