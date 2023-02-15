package ladder.dto;

import java.util.List;

public class LinesDto {

    private final List<List<Boolean>> lines;
    private final int height;

    public LinesDto(List<List<Boolean>> lines, int height) {
        this.lines = lines;
        this.height = height;
    }

    public List<List<Boolean>> getLines() {
        return lines;
    }

    public int getHeight() {
        return height;
    }
}
