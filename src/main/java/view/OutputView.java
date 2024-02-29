package view;

import domain.Game;
import domain.Line;
import domain.Lines;
import domain.Members;
import domain.Connection;
import domain.Reward;
import domain.Rewards;
import java.util.Map;

public class OutputView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String LADDER_VERTICAL = "|";
    private static final String LADDER_BLANK = " ";
    private static final String LADDER_HORIZONTAL = "-";

    public void printGame(Game game) {
        System.out.println("사다리 결과");
        printMembers(game.getMembers());
        printLines(game.getLines());
        printRewards(game.getRewards());
    }

    public void printRewardName(String rewardName) {
        System.out.println("실행 결과");
        System.out.println(rewardName);
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
        System.out.print(LADDER_BLANK.repeat(MAX_NAME_LENGTH - 1));
        System.out.print(LADDER_VERTICAL);
        for (Connection connection : line.getConnections()) {
            printConnection(connection);
            System.out.print(LADDER_VERTICAL);
        }
        System.out.println();
    }

    private void printConnection(Connection connection) {
        if (connection.equals(Connection.CONNECTED)) {
            System.out.print(LADDER_HORIZONTAL.repeat(MAX_NAME_LENGTH));
            return;
        }
        System.out.print(LADDER_BLANK.repeat(MAX_NAME_LENGTH));
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
