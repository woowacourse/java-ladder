package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ladder.dto.LinesDto;

public class Rows {

    private final List<Row> rows;

    public Rows(int height, int width) {
        Height.validateHeight(height);
        rows = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            rows.add(new Row(width));
        }
    }

    public void generateLegsOfLines(Generator generator) {
        rows.forEach(row -> row.generateLeg(generator));
    }

    public LinesDto toDto() {
        return new LinesDto(rows.stream()
                .map(Row::toDto)
                .collect(Collectors.toList()));
    }
}
