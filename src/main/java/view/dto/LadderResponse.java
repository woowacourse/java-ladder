package view.dto;

import java.util.List;
import model.Ladder;
import model.Line;

public class LadderResponse {
    private int paddingSize;
    private int playerCount;
    private List<Line> lines;

    public LadderResponse(int paddingSize, int playerCount, List<Line> lines) {
        this.paddingSize = paddingSize;
        this.playerCount = playerCount;
        this.lines = lines;
    }

    public static LadderResponse from(int paddingSize, Ladder ladder) {
        List<Line> lines = ladder.getLines();
        return new LadderResponse(paddingSize, ladder.width(), lines);
    }

    public List<Line> getLadder() {
        return lines;
    }

    public int getPaddingSize() {
        return paddingSize;
    }
}
