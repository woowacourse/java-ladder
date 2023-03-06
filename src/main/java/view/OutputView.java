package view;

import domain.*;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String BLANK = " ";
    private static final String EXIST_LINE = "-------";
    private static final String NON_EXIST_LINE = "       ";
    private static final String WALL = "|";
    private static final String COLON = ":";
    private static final int STANDARD_BLANK = 7;

    public static void printResultMessage() {
        System.out.println("\n실행 결과\n");
    }

    public static void printPlayers(Players players) {
        System.out.println(getPlayersNames(players));
    }

    public static String getPlayersNames(Players players) {
        StringBuilder sb = new StringBuilder();
        for (Player player : players.getPlayers()) {
            sb.append(player.getName());
            String blank = BLANK.repeat(STANDARD_BLANK - player.getName().length());
            sb.append(blank);
        }
        return sb.toString();
    }

    public static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            List<LineStep> oneLine = line.getLine();
            System.out.println(getLineStatus(oneLine));
        }
        System.out.println();
    }

    private static String getLineStatus(List<LineStep> line) {
        StringBuilder sb = new StringBuilder();

        sb.append(WALL);
        for (LineStep lineStep : line) {
            buildLine(sb, lineStep);
        }

        return sb.toString();
    }

    private static void buildLine(StringBuilder sb, LineStep lineStep) {
        if (lineStep.getStatus()) {
            sb.append(EXIST_LINE);
        }
        if (!lineStep.getStatus()) {
            sb.append(NON_EXIST_LINE);
        }
        sb.append(WALL);
    }

    public static void printAllResults(MatchingResult matchingResult) {
        Map<Player, Result> allResults = matchingResult.getMatchingResult();
        for (Map.Entry<Player, Result> finalResult : allResults.entrySet()) {
            System.out.println(finalResult.getKey().getName() + COLON + finalResult.getValue().getResult());
        }
    }

    public static void printFinalResult(Map<Player, Result> finalMatchingResult) {
        System.out.println("\n실행 결과");

        for (Map.Entry<Player, Result> finalResult : finalMatchingResult.entrySet()) {
            System.out.println(finalResult.getKey().getName() + COLON + finalResult.getValue().getResult());
        }
        System.out.println();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
