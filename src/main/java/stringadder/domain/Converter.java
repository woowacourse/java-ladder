package stringadder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    private static final int NUMBER_BOUND = 0;
    public static List<Integer> convert(List<String> input) {
        List<Integer> converted = new ArrayList<>();

        List<String> cleanInput = input.stream()
                .filter(x -> !x.equals(""))
                .collect(Collectors.toList());
        for (String digit : cleanInput) {
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
