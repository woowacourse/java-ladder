package ladder.dto;

import ladder.domain.Line;
import ladder.domain.StepStatus;

import java.util.List;

public record LineResult(List<StepStatus> value) {

    public static LineResult of(Line line) {
        return new LineResult(line.getStepStatuses());
    }
}
