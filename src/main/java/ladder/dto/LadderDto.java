package ladder.dto;

import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.ladder.Ladder;

public record LadderDto(List<LineDto> lines) {

    public static LadderDto from(Ladder ladder) {
        List<LineDto> lineDtos = IntStream.range(0, ladder.getHeight())
                .mapToObj(height -> LineDto.of(ladder, height))
                .toList();
        return new LadderDto(lineDtos);
    }
}
