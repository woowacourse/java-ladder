package domain;

import java.util.stream.Collectors;

class LadderString {
    static String from(Ladder ladder) {
        return ladder.getRows().stream()
                .map(RowString::from)
                .collect(Collectors.joining("\n"));
    }
}
