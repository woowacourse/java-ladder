package view;

import domain.*;

public class ResultView {

    private static final String LINE = "|-----";
    private static final String NONE_LINE = "|     ";


    private ResultView() {

    }

    public static void printNames(final Users users) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%-6s", users.getFirst()));
        users.getMiddleUsers().forEach(userName -> stringBuilder.append(String.format("%6s", userName)));
        stringBuilder.append(String.format("%5s", users.getLast()));

        System.out.println(stringBuilder);
    }

    public static void printLadderResult() {
        System.out.println("사다리 결과");
        System.out.println();
    }

    public static void printResults(final Results results) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%-6s", results.getFirst()));
        results.getMiddleResult().forEach(userName -> stringBuilder.append(String.format("%6s", userName)));
        stringBuilder.append(String.format("%5s", results.getLast()));

        System.out.println(stringBuilder);
    }

    public static void printLadder(final Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.println(generateSingleLine(line));
        }
    }

    public static void findPrize(String prize) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println(prize);
    }

    private static String generateSingleLine(final Line line) {
        return "    " + drawLine(line);
    }

    private static String drawLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Bridge bridge : line.getBridges()) {
            stringBuilder.append(drawBridge(bridge));
        }
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    private static String drawBridge(final Bridge bridge) {
        if (bridge.getBridge()) {
            return LINE;
        }
        return NONE_LINE;
    }
}
