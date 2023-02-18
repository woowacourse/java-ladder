package ladder.dto;

import java.util.List;

public class RowsDto {

    private final List<List<Boolean>> rows;

    public RowsDto(List<List<Boolean>> rows) {
        this.rows = rows;
    }

    public List<List<Boolean>> getRows() {
        return rows;
    }
}
