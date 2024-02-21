package view.dto;

import java.util.List;
import model.Ladder;
import model.Line;

public class LadderResponse {
    private final List<Line> lines;

    public LadderResponse(List<Line> lines) {
        this.lines = lines;
    }

    public static LadderResponse from(Ladder ladder) {
        return new LadderResponse(ladder.getLines());
    }

    public List<Line> getLadder() {
        return lines;
    }
}
