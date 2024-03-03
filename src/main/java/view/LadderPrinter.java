package view;

import java.util.List;
import java.util.stream.Collectors;

public class LadderPrinter {
    public static String from(List<List<Boolean>> rawLadder) {
        return rawLadder.stream()
                .map(LinePrinter::from)
                .collect(Collectors.joining("\n"));
    }
}
