package ladder.view;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final String OUTPUT_RESULT = "실행 결과";

    public static void outputLadder(String names, String lines, String rewards) {
        System.out.println(OUTPUT_RESULT);
        System.out.println(formatAlignRight(names));
        System.out.println(lines);
        System.out.println(formatAlignRight(rewards));
    }

    private static String formatAlignRight(String name) {
        List<String> names = Arrays.asList(name.split(","));
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : names) {
            stringBuilder.append(String.format("%6s", s));
        }
        return stringBuilder.toString();
    }

    public static void outputLadderReward(String reward) {
        System.out.println(OUTPUT_RESULT);
        System.out.println(reward);
    }
}
