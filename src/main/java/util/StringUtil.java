package util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static List<String> splitComma(String s) {
        return Arrays.asList(s.split(","));
    }
}
