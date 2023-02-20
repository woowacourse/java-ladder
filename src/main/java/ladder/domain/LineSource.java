package ladder.domain;

import java.util.Arrays;

public enum LineSource {
    MAKE_LINE(1),
    MAKE_BLANK(0);

    int odd;

    LineSource(int odd) {
        this.odd = odd;
    }

    public static LineSource of(int number) {
        return Arrays.stream(LineSource.values())
                .filter(lineSource -> lineSource.odd == number)
                .findAny()
                .orElse(LineSource.MAKE_BLANK);
    }
}
