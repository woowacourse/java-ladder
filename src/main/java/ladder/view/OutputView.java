package ladder.view;

public class OutputView {
    public static final String OUTPUT_RESULT = "실행 결과";

    public static void outputLadder(String names, String lines, String rewards) {
        System.out.println(OUTPUT_RESULT);
        System.out.println(names);
        System.out.println(lines);
        System.out.println(rewards);
    }

    public static void outputLadderReward(String reward) {
        System.out.println(OUTPUT_RESULT);
        System.out.println(reward);
    }
}
