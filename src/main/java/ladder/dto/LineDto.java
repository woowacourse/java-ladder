package ladder.dto;

import ladder.domain.ladder.Line;
import ladder.domain.ladder.Rung;

import java.util.List;
import java.util.stream.Collectors;

public record LineDto(List<Boolean> rungsExist) {

    public static LineDto from(final Line line) {
        final List<Rung> rungs = line.getRungs();

        return rungs.stream()
                .map(Rung::isExist)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LineDto::new));
    }
}
