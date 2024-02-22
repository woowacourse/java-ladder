package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.enums.NameFormat;
import ladder.domain.People;
import ladder.domain.RowLine;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String BLANK = " ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-";
    private static final int INTERVAL_WIDTH = 5;

    private OutputView() {
    }

    public static void printNames(People people) {
        StringJoiner nameJoiner = new StringJoiner(BLANK);
        List<String> names = people.getNames();

        for (String name : names) {
            String format = NameFormat.findFormat(name.length());
            nameJoiner.add(String.format(format, name));
        }
        System.out.println(nameJoiner);
    }

    public static void printLadder(Ladder ladder) {
        for (RowLine rowLine : ladder.getRowLines()) {
            printRowLine(rowLine);
        }
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
