package ladder.view;

import ladder.domain.*;

import java.util.List;

public class OutputConsoleView {
    private static final String THREE_TAB = "   ";
    private static final String VERTICAL_LINE = "|";
    private static final String SUB_LINE_TRUE = "-----";
    private static final String SUB_LINE_FALSE = "     ";
    private static final String PADDING = " ";
    private static final int MAX_NAME_LENGTH = 5;

    public static void printLadderGame(LadderGame ladderGame) {
        printNames(ladderGame.getPlayers());
        printLadder(ladderGame.getLadder());
    }

    private static void printNames(GamePlayers gamePlayers) {
        StringBuilder sb = new StringBuilder();
        sb.append(PADDING);
        for (Player player : gamePlayers.getPlayers()) {
            sb.append(fillPadding(player.getName()));
        }
        System.out.println(sb.toString());
    }

    private static String fillPadding(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            return name;
        }
        if (name.length() % 2 == 1) {
            return fillPadding(name + PADDING);
        }
        return fillPadding(PADDING + name);
    }

    private static void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            printLine(sb, line);
        }
        System.out.println(sb.toString());
    }

    private static void printLine(StringBuilder sb, Line line) {
        sb.append(THREE_TAB);
        for (Boolean subLine : line.getSubLines()) {
            printSubLines(sb, subLine);
        }
        sb.append(VERTICAL_LINE).append("\n");
    }

    private static void printSubLines(StringBuilder sb, Boolean subLine) {
        sb.append(VERTICAL_LINE);
        sb.append(subLine ? SUB_LINE_TRUE : SUB_LINE_FALSE);
    }
}
