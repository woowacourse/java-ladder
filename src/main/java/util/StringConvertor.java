package util;

import java.util.Arrays;
import java.util.List;

public class StringConvertor {
    public static final String DELIMITER = ",";

    private StringConvertor() {
    }

    public static String[] splitByComma(final String value) {
        return value.split(DELIMITER);
    }

    public static List<String> convertToTrimmedList(final String[] values) {
        return Arrays.stream(values).map(String::trim).toList();
    }

    public static int convertToInt(final String value) {
        return Integer.parseInt(value);
    }
}
