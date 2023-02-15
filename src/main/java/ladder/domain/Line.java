package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> blocks = new ArrayList<>();

    public Line(List<Boolean> blocks) {
        this.blocks = blocks;
    }

    public List<Boolean> getBlocks() {
        return blocks;
    }
}
