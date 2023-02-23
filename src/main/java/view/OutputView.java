package view;

import domain.*;

import java.util.List;

public class OutputView {
    public static final String FIRST_FORMAT = "%-5s";
    public static final String MIDDLE_FORMAT = "%6s";
    public static final String LAST_FORMAT = "%5s";
    public static final String VERTICAL_BAR = "|";
    public static final String LADDER_RESULT_GUIDE_MESSAGE = "\n" + "사다리 결과" + "\n";

    public static final String REWARD_GUIDE_MESSAGE = "\n" + "실행 결과";
    public static final String ALL = "all";
    public static final String COLON = " : ";

    private static void printMiddlePlayers(List<String> names, int index) {
        if (isMiddle(names.size(), index)) {
            System.out.printf(MIDDLE_FORMAT, names.get(index));
        }
    }

    private static boolean isMiddle(int size, int index) {
        return 0 < index && index < size - 1;
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
            printFirstPlayer(names, i);
            printLastPlayer(names, i);
            printMiddlePlayers(names, i);
        }
    }

    private void printFirstPlayer(List<String> names, int index) {
        if (isFirst(index)) {
            System.out.print(String.format(FIRST_FORMAT, names.get(index)));
        }
    }

    private static boolean isFirst(int i) {
        return i == 0;
    }

    private void printLastPlayer(List<String> names, int index) {
        if (isLast(names.size(), index)) {
            System.out.print(String.format(LAST_FORMAT, names.get(index)));
        }
    }

    private static boolean isLast(int size, int index) {
        return index == size - 1;
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
            if (isFirst(i)) {
                System.out.print(String.format(LAST_FORMAT, reward.getReward()));
            }
            if (isMiddle(rewardsRewards.size(), i)) {
                System.out.print(String.format(MIDDLE_FORMAT, reward.getReward()));
            }
            if (isLast(rewardsRewards.size(), i)) {
                System.out.print(String.format(LAST_FORMAT, reward.getReward()));
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

    private static void printPlayerReward(String input, Players players) {
        for (Player player : players.getPlayers()) {
            if(player.getName().equals(input)){
                System.out.println(player.getReward().getReward());
            }
        }
    }

    private static boolean isAll(String input) {
        return input.equals(ALL);
    }

    private static void printAllPlayersRewards(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.println(player.getName()+ COLON + player.getReward().getReward());
        }
    }
}
