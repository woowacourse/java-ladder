package ladder.dto.response;

import java.util.List;
import ladder.domain.ladder.Ladder;

public record LadderResponse(List<LineResponse> lineResponses) {
    public static LadderResponse from(Ladder ladder) {
        List<LineResponse> lineResponses = ladder.getLines().stream()
                .map(LineResponse::from)
                .toList();

        return new LadderResponse(lineResponses);
    }
}
