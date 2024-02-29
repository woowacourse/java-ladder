package ladder.domain.dto;

import java.util.List;
import ladder.domain.ladder.Step;

public record MadeLineDto(List<Step> line) {

    public boolean findPositionStepStatus(int stepPosition) {
        return line.get(stepPosition).getBuildStatus();
    }
}
