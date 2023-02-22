package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLines {

    private final List<Line> lines;

    private LadderLines(List<Line> lines) {
        this.lines = lines;
    }

    public static LadderLines of(StepPointGenerator stepPointGenerator, LineWidth width,
                                 LadderHeight height) {
        List<Line> generated = new ArrayList<>();
        for (int i = 0; i < height.get(); i++) {
            generated.add(Line.of(stepPointGenerator, width));
        }
        return new LadderLines(generated);
    }

    public List<Line> toLines() {
        return new ArrayList<>(lines);
    }

    public int height() {
        return lines.size();
    }
}
