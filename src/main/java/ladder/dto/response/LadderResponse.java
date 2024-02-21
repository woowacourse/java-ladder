package ladder.dto.response;

import java.util.List;
import ladder.domain.ladder.Ladder;

public record LadderResponse(List<LineResponse> lineResponses) {
    public static LadderResponse from(final Ladder ladder) {
        final List<LineResponse> lineResponses = ladder.getLines().stream()
                .map(LineResponse::from)
                .toList();
        return new LadderResponse(lineResponses);
    }
}
