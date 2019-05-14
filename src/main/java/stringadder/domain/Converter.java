package stringadder.domain;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    private static final int NUMBER_BOUND = 0;
    public static List<Integer> convert(List<String> input) {
        List<Integer> converted = new ArrayList<>();

        for (String digit : input) {
            checkPositive(digit);
            converted.add(Integer.parseInt(digit));
        }
        return converted;
    }

    private static void checkPositive(String digit) {
        if (Integer.parseInt(digit) < NUMBER_BOUND) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }
}
