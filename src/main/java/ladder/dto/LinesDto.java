package ladder.dto;

import java.util.List;

public class LinesDto {

    private final List<List<Boolean>> lines;

    public LinesDto(List<List<Boolean>> lines) {
        this.lines = lines;
    }

    public List<List<Boolean>> getLines() {
        return lines;
    }
}
