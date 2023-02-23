package view;

import domain.Ladder;
import domain.Line;
import domain.LineStatus;
import domain.Lines;
import domain.Player;
import domain.Players;
import domain.Results;
import java.util.List;

public class OutputView {

    private static final int STANDARD_BLANK = 7;
    private static final String EXIST_LINE = "-------";
    private static final String NON_EXIST_LINE = "       ";
    private static final String WALL = "|";

    public static void printResultMessage() {
        System.out.println("\n실행 결과\n");
    }

    public static void printPlayers(Players players) {
        System.out.println(getPlayersNames(players));
    }

    private static String getPlayersNames(Players players) {
        StringBuilder sb = new StringBuilder();

        for (Player player : players.getPlayers()) {
            sb.append(player.getName());
            String blank = " ".repeat(STANDARD_BLANK - player.getName().length());
            sb.append(blank);
        }

        return sb.toString();
    }

    public static void printLadder(Ladder ladder) {
        Lines lines = ladder.getLines();

        for (Line line : lines.getLines()) {
            List<LineStatus> oneLine = line.getLine();
            System.out.println(getLineStatus(oneLine));
        }
    }

    private static String getLineStatus(List<LineStatus> line) {
        StringBuilder sb = new StringBuilder();

        sb.append(WALL);
        for (LineStatus lineStatus : line) {
            buildLine(sb, lineStatus);
        }

        return sb.toString();
    }

    private static void buildLine(StringBuilder sb, LineStatus lineStatus) {
        if (lineStatus.getStatus()) {
            sb.append(EXIST_LINE);
        }
        if (!lineStatus.getStatus()) {
            sb.append(NON_EXIST_LINE);
        }
        sb.append(WALL);
    }

    public static void printLadderResult(Results results) {
        System.out.println(getLadderResult(results));
    }

    private static String getLadderResult(Results results) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < results.getSize(); i++) {
            sb.append(results.getResultByIndex(i));
            String blank = " ".repeat(STANDARD_BLANK - results.getSize());
            sb.append(blank);
        }

        return sb.toString();
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
