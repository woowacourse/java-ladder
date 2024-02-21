package ladder.dto;

import java.util.List;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Rung;

public record LineDto(List<Boolean> rungsExist) {

    public static LineDto from(Line line) {
        List<Rung> rungs = line.getRungs();
        List<Boolean> rungExist = rungs.stream()
                .map(Rung::isExist)
                .toList();

        return new LineDto(rungExist);
    }
}
