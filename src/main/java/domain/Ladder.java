package domain;

import java.util.List;

public class Ladder {

    private final Height height;
    private final List<RowLine> lines;

    public Ladder(Height height, List<RowLine> lines) {
        this.height = height;
        this.lines = lines;
    }

    public Integer getHeight() {
        return height.getHeight();
    }

    public Integer getWidth() {
        return lines.get(0).getConnections().size();
    }
}
