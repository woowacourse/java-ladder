package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import laddergame.utils.LineMaker;

public class LadderImpl implements Ladder{

    private final List<LineImpl> lines;
    private final Height height;
    private final int userCount;
    private final LineMaker lineMaker;

    public LadderImpl(Height height, int userCount, LineMaker lineMaker) {
        this.lines = new ArrayList<>();
        this.height = height;
        this.userCount = userCount;
        this.lineMaker = lineMaker;
        addLine();
    }

    private void addLine() {
        for (int line = 0; line < height.getHeight(); line++) {
            lines.add(new LineImpl(lineMaker, userCount));
        }
    }

    public List<LineImpl> getLines() {
        return lines;
    }
}
