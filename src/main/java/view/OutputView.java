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

    /*TODO: 지금처럼 player.getReward().getRewardName()을 player.getRewardName()로 변경하는 게 나을까요?
        Reward의 이름을 반환하는 건 Reward가 해야할 것 같은데 이렇게 코드를 변경하면 책임이 player까지 가는 것 아닐까요?
        또 다르게 생각해보면 어짜피 Player가 Reward라는 값객체를 가지고 있으니 괜찮은 것 같기도 해요.
        조앤은 어떻게 생각하시나요?? 조앤의 생각을 들려주세요! :D
     */
    private static void printPlayerReward(String input, Players players) {
        for (Player player : players.getPlayers()) {
            if (player.isSameNameWithInput(input)) {
                System.out.println(player.getRewardName());
            }
        }
    }

    private static boolean isAll(String input) {
        return input.equals(ALL);
    }

    private static void printAllPlayersRewards(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.println(player.getName() + COLON + player.getRewardName());
        }
    }

    public static void printResult(Players players, List<Line> ladder, Rewards rewards) {
        System.out.println(LADDER_RESULT_GUIDE_MESSAGE);
        printNames(players);
        printLadders(ladder);
        printRewards(rewards);
    }

    public static void printNames(Players players) {
        List<String> names = players.getPlayersName();
        for (int i = 0; i < names.size(); i++) {
            printFirstOrLastPlayer(i, names);
            printMiddlePlayers(i, names);
        }
    }

    private static void printFirstOrLastPlayer(int index, List<String> names) {
        if (isFirstOrLast(index, names.size())) {
            System.out.printf(FIRST_OR_LAST_FORMAT, names.get(index));
        }
    }

    public static void printLadders(List<Line> lines) {
        System.out.println();
        for (Line line : lines) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        List<String> ladders = BlockType.getBlockTypes(line);
        System.out.println("    " + VERTICAL_BAR + String.join(VERTICAL_BAR, ladders) + VERTICAL_BAR);
    }

    public static void printRewards(Rewards rewards) {
        List<Reward> rewardsRewards = rewards.getRewards();
        for (int i = 0; i < rewardsRewards.size(); i++) {
            Reward reward = rewardsRewards.get(i);
            printFirstOrLastReward(rewardsRewards, i, reward);
            printMiddleReward(rewardsRewards, i, reward);
        }
    }

    private static void printMiddleReward(List<Reward> rewardsRewards, int i, Reward reward) {
        if (isMiddle(i, rewardsRewards.size())) {
            System.out.printf(MIDDLE_FORMAT, reward.getRewardName());
        }
    }

    private static void printFirstOrLastReward(List<Reward> rewardsRewards, int i, Reward reward) {
        if (isFirstOrLast(i, rewardsRewards.size())) {
            System.out.printf(FIRST_OR_LAST_FORMAT, reward.getRewardName());
        }
    }

    public static void printReward(String input, Players players) {
        System.out.println(REWARD_GUIDE_MESSAGE);
        if (isAll(input)) {
            printAllPlayersRewards(players);
            return;
        }
        printPlayerReward(input, players);
    }
}
