package laddergame.view;

import laddergame.domain.ladder.Connection;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RowLine;
import laddergame.domain.people.Name;
import laddergame.domain.people.People;
import laddergame.view.enums.NameFormat;

import java.util.List;
import java.util.StringJoiner;

import static laddergame.domain.ladder.Connection.CONNECTED;

public class ResultView {
    private static final String BLANK = " ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-";
    private static final int INTERVAL_WIDTH = 5;

    private ResultView() {
    }

    public static void printNames(People people) {
        StringJoiner nameJoiner = new StringJoiner(BLANK);
        List<String> names = people.getNames()
                .stream()
                .map(Name::getName)
                .toList();

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

        for (Connection isConnected : rowLine.getConnections()) {
            stringBuilder.append(findConnectionMark(isConnected).repeat(INTERVAL_WIDTH));
            stringBuilder.append(VERTICAL_LINE);
        }
        System.out.println(stringBuilder);
    }

    private static String findConnectionMark(Connection isConnected) {
        if (isConnected == CONNECTED) {
            return HORIZONTAL_LINE;
        }
        return BLANK;
    }
}
