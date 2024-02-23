package view;

import java.util.List;
import java.util.stream.Collectors;

class RowPrinter {
    static String from(List<Boolean> bridges) {
        String rawRowString = bridges.stream().map(RowPrinter::makeBridge)
                .collect(Collectors.joining("|"));
        return "    |%s|".formatted(rawRowString);
    }

    private static String makeBridge(Boolean aBoolean) {
        if (aBoolean) {
            return "-----";
        }
        return "     ";
    }
}
