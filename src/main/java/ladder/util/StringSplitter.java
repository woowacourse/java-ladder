package ladder.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {

    public static List<String> splitString(String string) {
        return Arrays.stream(string.split(","))
                .collect(Collectors.toUnmodifiableList());
    }
}
