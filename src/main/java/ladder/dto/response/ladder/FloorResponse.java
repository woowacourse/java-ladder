package ladder.dto.response.ladder;

import java.util.List;
import ladder.domain.ladder.Floor;
import ladder.domain.ladder.Rung;

public record FloorResponse(List<Boolean> rungsExist) {
    public static FloorResponse from(Floor floor) {
        List<Boolean> rungsExist = floor.getRungs().stream()
                .map(Rung::isExist)
                .toList();

        return new FloorResponse(rungsExist);
    }
}
