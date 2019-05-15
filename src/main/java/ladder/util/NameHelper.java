package ladder.util;

import java.util.Arrays;
import java.util.List;

public class NameHelper {

    static List<String> splitNames(String names) {
        return Arrays.asList(names.split(","));
    }
}
