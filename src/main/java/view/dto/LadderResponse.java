package view.dto;

import java.util.List;
import model.Ladder;
import model.Line;

public class LadderResponse {
    private int playerCount;
    private List<Line> lines;

    public LadderResponse(int playerCount, List<Line> lines) {
        this.playerCount = playerCount;
        this.lines = lines;
    }

    public static LadderResponse from(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        return new LadderResponse(ladder.width(), lines);
    }
}
