package domain;

import domain.validator.LadderValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {


    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        LadderValidator.validate(lines);
        this.lines = new ArrayList<>(lines);
    }
    
    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
