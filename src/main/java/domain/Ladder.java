package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private List<LadderRow> ladderRows = new ArrayList<>();

    public void add(LadderRow line) {
        ladderRows.add(line);
    }

    public List<LadderRow> getLadderRows() {
        return Collections.unmodifiableList(ladderRows);
    }

    public List<String> parseLadderToString() {
        return ladderRows.stream()
                .map(LadderRow::parseLineToString)
                .collect(Collectors.toUnmodifiableList());
    }
}
