package ladder.view;

import ladder.domain.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final int PADDING_WIDTH = 5;

    public static void printPlayerNames(Players players) {
        System.out.println("\n사다리 결과");
        List<PlayerName> names = players.getPlayerNames();
        for (PlayerName name : names) {
            System.out.printf("%s ", StringUtils.center(name.getName(), PADDING_WIDTH));
        }
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        while (ladder.hasNextLine()) {
            printLine(ladder.getNextLine());
        }
    }

    private static void printLine(Line line) {
        System.out.print("  |");
        List<Point> points = line.getPoints();
        for (int i=0; i<points.size() - 1; i++) {
            printPoint(points.get(i));
            System.out.print("|");
        }
        System.out.println();
    }

    private static void printPoint(Point point) {
        if (point.getCurrent()) {
            System.out.print("-----");
            return;
        }
        System.out.print("     ");
    }

    public static void printRewards(Rewards rewards) {
        for (Reward reward : rewards.getRewards()) {
            System.out.printf("%s ", StringUtils.center(reward.getName(), PADDING_WIDTH));
        }
        System.out.println("\n");
    }

    public static void printReward(Reward reward) {
        System.out.println("\n실행 결과");
        System.out.println(reward.getName());
    }

    public static void printResults(Results result) {
        System.out.println("\n실행 결과");
        Map<PlayerName, Reward> resultMap = result.getResults();
        for (Map.Entry<PlayerName, Reward> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue().getName());
        }
    }
}
