package ladder.dto;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;

import java.util.List;
import java.util.stream.Collectors;

public record LadderDto(List<LineDto> lineDtos) {

    public static LadderDto from(final Ladder ladder) {
        final List<Line> lines = ladder.getLines();

        return lines.stream()
                .map(LineDto::from)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LadderDto::new));
    }
}
