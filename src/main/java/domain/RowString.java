package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RowString {
    public static String from(Row row) {
        List<Boolean> rowInfos = row.getRowInfos();
        String rawRowString = rowInfos.stream().map(RowString::makeBridge)
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
