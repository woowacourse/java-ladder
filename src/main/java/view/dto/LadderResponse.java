package view.dto;

import java.util.List;
import model.Ladder;

public class LadderResponse {
    private final List<LineResponse> lines;

    private LadderResponse(List<LineResponse> lines) {
        this.lines = lines;
    }

    public static LadderResponse from(Ladder ladder) {
        List<LineResponse> lineResponses = ladder.getLines()
                .stream()
                .map(line -> LineResponse.from(line))
                .toList();
        return new LadderResponse(lineResponses);
    }

    public List<LineResponse> getLadderResponse() {
        return lines;
    }
}
