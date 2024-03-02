package ladder.controller.dto;

import java.util.List;
import ladder.domain.ladder.Rung;

public record FloorResponseDto(List<Boolean> buildStatusList) {

    public static FloorResponseDto from(List<Rung> rungs) {
        List<Boolean> buildStatusList = rungs.stream()
                .map(Rung::isBuildStatus)
                .toList();

        return new FloorResponseDto(buildStatusList);
    }
}
