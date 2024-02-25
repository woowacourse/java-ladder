package ladder.dto;

import ladder.domain.ladder.Line;
import ladder.domain.ladder.Rung;

import java.util.List;

public record LineDto(List<Boolean> rungsExist) {

    public static LineDto from(final Line line) {
        final List<Rung> rungs = line.getRungs();
        final List<Boolean> rungExist = rungs.stream()
                .map(Rung::isExist)
                .toList();

        return new LineDto(rungExist);
    }
}
