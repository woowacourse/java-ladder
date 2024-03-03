package domain.model.ladder;

import utils.RuleGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();
    private final Height height;

    public Ladder(Height height, int personCount, RuleGenerator ruleGenerator) {
        this.height = height;

        for (int i = 0; i < height.getHeight(); i++) {
            Line line = new Line(ruleGenerator, personCount);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int goToConsequence(int position, int sequence) {
        if (sequence == lines.size()) {
            return position;
        }
        Line currentLine = lines.get(sequence);
        Direction direction = currentLine.showDirection(position);
        return goToConsequence(position + direction.getMovementOfIndex(), sequence + 1);
    }
}
