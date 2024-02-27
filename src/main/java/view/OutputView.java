package view;

import domain.Game;
import domain.Line;
import domain.Lines;
import domain.Members;
import domain.Point;
import domain.Reward;
import domain.Rewards;
import java.util.Map;

public class OutputView {

    public static final int MAX_NAME_LENGTH = 5;

    public void printGame(Game game) {
        System.out.println("사다리 결과");
        printMembers(game.getMembers());
        printLines(game.getLines());
        printRewards(game.getRewards());
    }

    public void printOneResult(String memberName, Map<String, String> rewardMap) {
        System.out.println("실행 결과");
        System.out.println(rewardMap.get(memberName));
    }

    public void printAllResult(Map<String, String> rewardMap) {
        System.out.println("실행 결과");
        for (String memberName : rewardMap.keySet()) {
            System.out.println(memberName + " : " + rewardMap.get(memberName));
        }
    }

    private void printMembers(Members members) {
        for (String name : members.getNames()) {
            System.out.printf("%" + MAX_NAME_LENGTH + "s ", name);
        }
        System.out.println();
    }

    private void printLines(Lines lines) {
        for (Line line : lines.getLines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        System.out.print(" ".repeat(MAX_NAME_LENGTH - 1));
        System.out.print("|");
        for (Point point : line.getPoints()) {
            printPoint(point);
            System.out.print("|");
        }
        System.out.println();
    }

    private void printPoint(Point point) {
        if (point.equals(Point.CONNECTED)) {
            System.out.print("-".repeat(MAX_NAME_LENGTH));
            return;
        }
        System.out.print(" ".repeat(MAX_NAME_LENGTH));
    }

    private void printRewards(Rewards rewards) {
        for (Reward reward : rewards.getRewards()) {
            printRewardFormatted(reward);
        }
        System.out.println();
    }

    private void printRewardFormatted(Reward reward) {
        if (reward.getName().equals("꽝")) {
            System.out.printf("%" + (MAX_NAME_LENGTH - 1) + "s ", reward.getName());
            return;
        }
        System.out.printf("%" + MAX_NAME_LENGTH + "s ", reward.getName());
    }
}
