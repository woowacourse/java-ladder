package ladder.view;

import ladder.domain.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class OutputView {
    private static final int PADDING_WIDTH = 5;

    public static void printPlayerNames(Players players) {
        System.out.println("사다리 결과");
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
        for (Point point : line.getPoints()) {
            printPoint(point);
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
        System.out.println("실행 결과");
        System.out.println(reward.getName());
    }
}
