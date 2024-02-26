package ladder.dto.response.ladder;

import java.util.List;
import ladder.domain.ladder.Ladder;

public record LadderResponse(List<FloorResponse> floorResponses) {
    public static LadderResponse from(Ladder ladder) {
        List<FloorResponse> floorResponses = ladder.getFloors().stream()
                .map(FloorResponse::from)
                .toList();

        return new LadderResponse(floorResponses);
    }
}
