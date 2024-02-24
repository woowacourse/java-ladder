package ladder.domain.dto;

import java.util.List;
import ladder.domain.Rung;

public record LineResponseDto(List<Boolean> buildStatusList) {

    public static LineResponseDto of(List<Rung> rungs) {
        List<Boolean> buildStatusList = rungs.stream()
                .map(Rung::isBuildStatus)
                .toList();

        return new LineResponseDto(buildStatusList);
    }
}
