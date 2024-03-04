package ladder.domain.dto;

import java.util.List;

public record MadeLadderDto(List<MadeLineDto> madeLines) {

    public boolean checkLineStepStatus(int linePosition, int stepPosition) {
        return madeLines.get(linePosition).findPositionStepStatus(stepPosition);
    }
}
