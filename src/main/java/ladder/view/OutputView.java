package ladder.view;

import ladder.util.Const;

public class OutputView {
    public static void outputLadder(String names, String lines, String rewards) {
        System.out.println(Const.OUTPUT_RESULT);
        System.out.println(names);
        System.out.println(lines);
        System.out.println(rewards);
    }

    public static void outputLadderReward(String reward) {
        System.out.println(Const.OUTPUT_RESULT);
        System.out.println(reward);
    }
}
