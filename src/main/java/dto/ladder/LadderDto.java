package dto.ladder;

import domain.ladder.Ladder;
import java.util.List;

public class LadderDto {
    private final List<LineDto> lines;

    private LadderDto(List<LineDto> lines) {
        this.lines = lines;
    }

    public static LadderDto from(Ladder ladder) {
        return new LadderDto(ladder.getLines());
    }

    public List<LineDto> getLines() {
        return lines;
    }
}
