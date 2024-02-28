package domain.model;

import utils.RuleGenerator;
import utils.RuleGeneratorImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();
    private final Height height;

    public Ladder(String inputHeight, int personCount, RuleGenerator ruleGenerator) {
        this.height = new Height(inputHeight);

        for (int i = 0; i < height.getHeight(); i++) {
            Line line = new Line(ruleGenerator, personCount);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
