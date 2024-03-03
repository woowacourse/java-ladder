package view;

import dto.LadderGameResults;
import java.util.stream.Collectors;

public class LadderGameResultsPrinter {
    static String from(LadderGameResults ladderGameResults) {
        return ladderGameResults.ladderGameResults().stream()
                .map(LadderGameResultPrinter::from)
                .collect(Collectors.joining("\n"));
    }
}
