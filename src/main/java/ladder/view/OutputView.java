package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.NameFormat;
import ladder.domain.People;
import ladder.domain.RowLine;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    //TODO String 상수 Enum으로 변경 고민해보기
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
        StringBuilder stringBuilder = new StringBuilder(BLANK.repeat(INTERVAL_WIDTH - 1) + VERTICAL_LINE);

        for (boolean isConnected : rowLine.getConnection()) {
            appendLineInterval(isConnected, stringBuilder);
            stringBuilder.append(VERTICAL_LINE);
        }
        System.out.println(stringBuilder);
    }

    private static void appendLineInterval(boolean isConnected, StringBuilder stringBuilder) {
        if (isConnected) {
            stringBuilder.append(HORIZONTAL_LINE.repeat(INTERVAL_WIDTH));
        }
        if (!isConnected) {
            stringBuilder.append(BLANK.repeat(INTERVAL_WIDTH));
        }
    }

}
