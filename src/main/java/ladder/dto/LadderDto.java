package ladder.dto;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;

import java.util.List;

public record LadderDto(List<LineDto> lineDtos) {
    public static LadderDto from(final Ladder ladder) {
        final List<Line> lines = ladder.getLines();
        final List<LineDto> lineDtos = lines.stream()
                .map(LineDto::from)
                .toList();

        return new LadderDto(lineDtos);
    }
}
