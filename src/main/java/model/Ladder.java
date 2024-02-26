package model;

import utils.RuleGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();
    private final Height height;

    public Ladder(String input, int personCount) {
        this.height = new Height(input);
        RuleGeneratorImpl ruleGenerator = new RuleGeneratorImpl();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(ruleGenerator, personCount));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
