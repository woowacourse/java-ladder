package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ladder.dto.RowsDto;

public class Rows {

    private final List<Row> rows;

    public Rows(int height, int width) {
        validateHeight(height);
        rows = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            rows.add(new Row(width));
        }
    }

    private void validateHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("높이는 0보다 커댜 합니다");
        }
    }


    public void generateLegsOfLines(Generator generator) {
        rows.forEach(row -> row.generateLeg(generator));
    }

    public RowsDto toDto() {
        return new RowsDto(rows.stream()
                .map(Row::toDto)
                .collect(Collectors.toList()));
    }
}
