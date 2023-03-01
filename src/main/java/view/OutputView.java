package view;

import domain.*;

import java.util.LinkedHashMap;
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

    public static void printFinalResult(Map<Player, Result> finalMatchingResult, Players players, String[] matchingNames) {
        System.out.println("\n실행 결과");
        Map<Player, Result> finalResults = selectResultToPrint(finalMatchingResult, players, matchingNames);
        for (Map.Entry<Player, Result> finalResult : finalResults.entrySet()) {
            System.out.println(finalResult.getKey().getName() + COLON + finalResult.getValue().getResult());
        }
        System.out.println();
    }

    private static Map<Player, Result> selectResultToPrint(Map<Player, Result> finalResults, Players players, String[] matchingNames) {
        if (matchingNames[0].equals("all")) {
            return finalResults;
        }
        Map<Player, Result> finalMatchingResult = new LinkedHashMap<>();
        for (String matchingName : matchingNames) {
            Player player = players.findPlayer(matchingName);
            Result result = finalResults.get(player);
            finalMatchingResult.put(player, result);
        }
        return finalMatchingResult;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
