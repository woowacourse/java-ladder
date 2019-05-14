package StringAddCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    static List<Integer> splitString(String input, String[] splitter) {
        return convertStringToInt(replaceSplitter(input, splitter).split(" "));
    }

    private static String replaceSplitter(String input, String[] splitter) {
        for (int i = 0; i < splitter.length; i++) {
            input = input.replaceAll(splitter[i], " ");
        }
        return input;
    }

    private static List<Integer> convertStringToInt(String[] split) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            result.add(Integer.parseInt(split[i]));
        }
        return result;
    }

    static int add(List<Integer> input) {
        int sum = 0;
        for (Integer num : input) {
            sum += num;
        }
        return sum;
    }
}
