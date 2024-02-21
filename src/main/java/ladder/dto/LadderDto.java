package ladder.dto;

import java.util.List;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;

public record LadderDto(List<LineDto> lineDtos) {
    public static LadderDto from(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        List<LineDto> lineDtos = lines.stream()
                .map(LineDto::from)
                .toList();

        return new LadderDto(lineDtos);
    }
}
