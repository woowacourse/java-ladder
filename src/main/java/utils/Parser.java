package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final int SPLIT_LIMIT = -1;

    public static List<String> parse(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter, SPLIT_LIMIT))
                .collect(Collectors.toList());
    }
}
