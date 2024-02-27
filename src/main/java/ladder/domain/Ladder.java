package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public record Ladder(List<Line> lines) {
    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public int width() {
        if (lines.isEmpty()) {
            return 0;
        }
        return lines.get(0).scaffolds().size();
    }

    public int height() {
        return lines.size();
    }

    @Override
    public List<Line> lines() {
        return List.copyOf(lines);
    }
}
