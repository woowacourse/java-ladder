package ladder.domain.ladder;

import ladder.domain.valueGenerator.ValueGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    private Ladder(List<Line> lines) {
        this.ladder = new ArrayList<>(lines);
    }

    public static Ladder create(int count, int height, ValueGenerator valueGenerator) {
        List<Line> lines = new ArrayList<>();

        for (int idx = 0; idx < height; idx++) {
            List<Bar> bars = LineMaker.generate(count, valueGenerator);
            lines.add(new Line(bars));
        }

        return new Ladder(lines);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }


}
