package domain;

import java.util.stream.Collectors;

class LadderStringMaker {
    private LadderStringMaker() {

    }

    static String make(Ladder ladder) {
        return ladder.getRows().stream()
                .map(RowStringMaker::make)
                .collect(Collectors.joining("\n"));
    }
}
