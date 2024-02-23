package domain;

import java.util.stream.Collectors;

class LadderPrinter {
    static String from(Ladder ladder) {
        return ladder.getRows().stream()
                .map(RowPrinter::from)
                .collect(Collectors.joining("\n"));
    }
}
