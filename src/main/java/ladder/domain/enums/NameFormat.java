package ladder.domain.enums;

import java.util.Arrays;

public enum NameFormat {
    DEFAULT(0, "%s "),
    ONE(1, "  %s  "),
    TWO(2, "  %s "),
    THREE(3, " %s "),
    FOUR(4, "%s "),
    FIVE(5, "%s");

    private final int nameLength;
    private final String format;

    NameFormat(int nameLength, String format) {
        this.nameLength = nameLength;
        this.format = format;
    }

    public static String findFormat(int nameLength) {
        return Arrays.stream(values())
                .filter(f -> f.nameLength == nameLength)
                .map(f -> f.format)
                .findFirst()
                .orElse(DEFAULT.format);
    }
}
