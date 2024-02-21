package parser;

import java.util.Arrays;
import java.util.List;

public class NameParser {

    public static List<String> parse(String text) {
        return Arrays.stream(text.split(","))
                .map(String::trim)
                .toList();
    }
}
