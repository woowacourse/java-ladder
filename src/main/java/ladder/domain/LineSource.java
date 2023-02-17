package ladder.domain;

import java.util.Arrays;

public enum LineSource {
    MakeLine(1),
    MakeBlank(0);

    private final int odd;

    LineSource(int odd) {
        this.odd = odd;
    }

    public static LineSource of(int number){

        return Arrays.stream(LineSource.values())
                .filter(lineSource -> lineSource.odd == number)
                .findAny()
                .orElse(LineSource.MakeBlank);
    }

}
