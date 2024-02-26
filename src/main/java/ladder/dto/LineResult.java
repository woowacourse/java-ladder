package ladder.dto;

import ladder.domain.Line;
import ladder.domain.PathStatus;

import java.util.List;

public record LineResult(List<PathStatus> value) {

    public static LineResult of(Line line) {
        return new LineResult(line.getStepStatuses());
    }
}
