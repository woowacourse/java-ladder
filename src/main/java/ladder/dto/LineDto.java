package ladder.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Rung;

public class LineDto {
    private final List<Boolean> rungsExist;

    private LineDto(List<Boolean> rungsExist) {
        this.rungsExist = new ArrayList<>(rungsExist);
    }

    public static LineDto from(Line line) {
        List<Rung> rungs = line.getRungs();
        List<Boolean> rungExist = rungs.stream()
                .map(Rung::isExist)
                .toList();

        return new LineDto(rungExist);
    }

    public List<Boolean> getRungsExist() {
        return Collections.unmodifiableList(rungsExist);
    }
}
