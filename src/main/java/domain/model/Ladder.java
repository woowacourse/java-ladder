package domain.model;

import utils.RuleGeneratorImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();
    private final Height height;

    public Ladder(String input, int personCount) {
        this.height = new Height(input);

        for (int i = 0; i < height.getHeight(); i++) {
            Line line=new Line(new RuleGeneratorImpl(),personCount);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
