package laddergame.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    public static List<String> splitByComma(final String names) {
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
