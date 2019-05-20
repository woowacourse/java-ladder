package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Map;

public class OutputConsoleView {
    private static final String THREE_TAB = "   ";
    private static final String VERTICAL_LINE = "|";
    private static final String SUB_LINE_TRUE = "-----";
    private static final String SUB_LINE_FALSE = "     ";
    private static final String PADDING = " ";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ILLEGAL_NAME = "없는 사용자입니다.";

    public static void printLadderGame(Ladder ladder, GamePlayers gamePlayers, PlayerRewards playerRewards) {
        printNames(gamePlayers);
        printLadder(ladder);
        printRewards(playerRewards);
    }

    private static void printNames(GamePlayers gamePlayers) {
        StringBuilder sb = new StringBuilder();
        sb.append(PADDING);
        for (Player player : gamePlayers.getAllPlayers()) {
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
        System.out.print(sb.toString());
    }

    private static void printLine(StringBuilder sb, Line line) {
        sb.append(THREE_TAB);
        for (int i = 1; i < line.getDirections().size(); i++) {
            Direction subLine = line.getDirections().get(i);
            printSubLines(sb, subLine.isLeft());
        }
        sb.append(VERTICAL_LINE).append("\n");
    }

    private static void printSubLines(StringBuilder sb, Boolean subLine) {
        sb.append(VERTICAL_LINE);
        sb.append(subLine ? SUB_LINE_TRUE : SUB_LINE_FALSE);
    }

    private static void printRewards(PlayerRewards rewards) {
        Map<Integer, Reward> allRewards = rewards.getAllRewards();
        StringBuilder sb = new StringBuilder();
        sb.append(PADDING);
        for (Reward reward : allRewards.values()) {
            sb.append(fillPadding(reward.getName()));
        }
        System.out.println(sb.toString());
    }

    public static void printResult(GameResult gameResult, Player player) {
        System.out.println("실행 결과");
        Reward reward = gameResult.get(player);
        if (reward == null) {
            System.out.println(ILLEGAL_NAME);
            return;
        }
        System.out.println(reward.getName());
        System.out.println();
    }

    public static void printResult(GameResult gameResult) {
        Map<Player, Reward> results = gameResult.getAllResults();
        System.out.println("실행 결과");
        results.forEach((player, reward) -> {
            System.out.println(player.getName() + " : " + reward.getName());
        });
        System.out.println();
    }
}
