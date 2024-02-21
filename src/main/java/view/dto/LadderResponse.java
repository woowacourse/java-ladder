package view.dto;

import java.util.List;
import model.Ladder;
import model.Line;

public class LadderResponse {
    private int paddingSize;
    private List<Line> lines;

    public LadderResponse(int paddingSize, List<Line> lines) {
        this.paddingSize = paddingSize;
        this.lines = lines;
    }

    public static LadderResponse from(int paddingSize, Ladder ladder) {
        List<Line> lines = ladder.getLines();
        return new LadderResponse(paddingSize, lines);
    }

    public List<Line> getLadder() {
        return lines;
    }

    public int getPaddingSize() {
        return paddingSize;
    }
}
