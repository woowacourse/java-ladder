package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String DEFALUT_REGEX = "[,]|[:]";
    private static final String PATTERN = "//(.+)\n";
    private static final String BLANC = "";
    private static final String NUM_REGEX = "\\d+";

    public int add(String text) {
        int[] nums = makeIntegers(text);

        return Arrays.stream(nums).sum();
    }

    private int[] makeIntegers(String text) {
        String regex = makeRegex(text);

        String[] textNums = textFilter(text).split(regex);
        int length = textNums.length;
        int[] nums = new int[length];

        if (textNums[0].equals("")) {
            return new int[]{0};
        }

        for (int i = 0; i < length; i++) {
            nums[i] = validNum(Integer.parseInt(textNums[i]));
        }
        return nums;
    }

    public String makeRegex(String text) {
        StringBuilder regex = new StringBuilder(DEFALUT_REGEX);
        Matcher matcher = Pattern.compile(PATTERN).matcher(text);

        while (matcher.find()) {
            regex.append("|(").append(checkRegex(matcher.group(1))).append(")");
        }

        return regex.toString();
    }

    public String textFilter(String text) {
        return text.replaceAll(PATTERN, BLANC);
    }

    private int validNum(int num) {
        if (num < 0) throw new RuntimeException();
        return num;
    }

    public String checkRegex(String regex) {
        if (regex.matches(NUM_REGEX)) {
            throw new IllegalArgumentException();
        }
        return regex;
    }
}
