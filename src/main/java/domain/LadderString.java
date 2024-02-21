package domain;

import java.util.stream.Collectors;

public class LadderString {
    public static String from(Ladder ladder) {
        return ladder.getRows().stream()
                .map(RowString::from)
                .collect(Collectors.joining("\n"));
    }
}
