package ladder.dto;

import java.util.List;
import ladder.domain.Step;

public class LadderDto {

    private final List<List<Step>> lines;
    private final int height;

    public LadderDto(List<List<Step>> lines, int height) {
        this.lines = lines;
        this.height = height;
    }

    public List<List<Step>> getLines() {
        return lines;
    }
}
