package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderString {
    public static String from(Ladder ladder) {
        return ladder.getRows().stream()
                .map(row -> {
                    List<Boolean> rowInfos = row.getRowInfos();
                    String rawRowString = rowInfos.stream().map(aBoolean -> {
                        if (aBoolean) {
                            return "-----";
                        }
                        return "     ";
                    }).collect(Collectors.joining("|"));
                    return "    |%s|".formatted(rawRowString);
                })
                .collect(Collectors.joining("\n"));

    }
}
