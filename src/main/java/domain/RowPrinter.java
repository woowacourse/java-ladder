package domain;

import java.util.List;
import java.util.stream.Collectors;

class RowPrinter {
    static String from(Row row) {
        List<Boolean> rowInfos = row.getBridges();
        String rawRowString = rowInfos.stream().map(RowPrinter::makeBridge)
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
