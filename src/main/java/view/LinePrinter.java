package view;

import java.util.List;
import java.util.stream.Collectors;

public class LinePrinter {
    static String from(List<Boolean> canGoRights) {
        String rawRowString = canGoRights.stream().map(LinePrinter::makeBridge)
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
