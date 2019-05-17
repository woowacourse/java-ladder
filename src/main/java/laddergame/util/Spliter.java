package laddergame.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Spliter {
    public static List<String> splitByComma(String names) {
        if (names.endsWith(",")) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다!");
        }
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
