package ladder.view.enums;

import java.util.Arrays;
import java.util.Optional;

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
        Optional<String> optionalString = Arrays.stream(values())
                .filter(f -> f.nameLength == nameLength)
                .map(f -> f.format)
                .findFirst();

        return optionalString.orElseGet(() -> DEFAULT.format);
    }
}
