package dto.ladder;

import domain.ladder.Ladder;
import domain.ladder.Line;
import java.util.List;

public class LadderDto {
    private final List<Line> lines;

    public LadderDto(List<Line> lines) {
        this.lines = lines;
    }

    public static LadderDto from(Ladder ladder) {
        return new LadderDto(ladder.getLines());
    }

    public List<Line> getLines() {
        return lines;
    }
}
