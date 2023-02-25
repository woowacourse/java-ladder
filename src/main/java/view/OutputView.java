package view;

import domain.*;

import java.util.List;

public class OutputView {
    public static final String FIRST_OR_LAST_FORMAT = "%5s";
    public static final String MIDDLE_FORMAT = "%6s";
    public static final String VERTICAL_BAR = "|";
    public static final String LADDER_RESULT_GUIDE_MESSAGE = "\n" + "사다리 결과" + "\n";
    public static final String REWARD_GUIDE_MESSAGE = "\n" + "실행 결과";
    public static final String ALL = "all";
    public static final String COLON = " : ";

    private static void printMiddlePlayers(int index, List<String> names) {
        if (isMiddle(index, names.size())) {
            System.out.printf(MIDDLE_FORMAT, names.get(index));
        }
    }

    private static boolean isMiddle(int index, int size) {
        return 0 < index && index < size - 1;
    }

    private static boolean isFirstOrLast(int index, int size) {
        return index == 0 || index == size - 1;
    }

    private static void printPlayerReward(String input, Players players) {
        for (Player player : players.getPlayers()) {
            if (player.getName().equals(input)) {
                System.out.println(player.getReward().getReward());
            }
        }
    }

    private static boolean isAll(String input) {
        return input.equals(ALL);
    }

    private static void printAllPlayersRewards(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.println(player.getName() + COLON + player.getReward().getReward());
        }
    }

    public void printResult(Players players, List<Line> ladder, Rewards rewards) {
        System.out.println(LADDER_RESULT_GUIDE_MESSAGE);
        printNames(players);
        printLadders(ladder);
        printRewards(rewards);
    }

    public void printNames(Players players) {
        List<String> names = players.getPlayersName();
        for (int i = 0; i < names.size(); i++) {
            printFirstOrLastPlayer(i, names);
            printMiddlePlayers(i, names);
        }
    }

    private void printFirstOrLastPlayer(int index, List<String> names) {
        if (isFirstOrLast(index, names.size())) {
            System.out.printf(FIRST_OR_LAST_FORMAT, names.get(index));
        }
    }

    public void printLadders(List<Line> lines) {
        System.out.println();
        for (Line line : lines) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        List<String> ladders = BlockType.getBlockTypes(line);
        System.out.println("    " + VERTICAL_BAR + String.join(VERTICAL_BAR, ladders) + VERTICAL_BAR);
    }

    public void printRewards(Rewards rewards) {
        List<Reward> rewardsRewards = rewards.getRewards();
        for (int i = 0; i < rewardsRewards.size(); i++) {
            Reward reward = rewardsRewards.get(i);
            if (isFirstOrLast(i, rewardsRewards.size())) {
                System.out.printf(FIRST_OR_LAST_FORMAT, reward.getReward());
            }
            if (isMiddle(i, rewardsRewards.size())) {
                System.out.printf(MIDDLE_FORMAT, reward.getReward());
            }
        }
    }

    public void printReward(String input, Players players) {
        System.out.println(REWARD_GUIDE_MESSAGE);

        if (isAll(input)) {
            printAllPlayersRewards(players);
            return;
        }

        printPlayerReward(input, players);
    }
}
