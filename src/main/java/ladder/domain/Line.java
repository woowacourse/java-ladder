package ladder.domain;

import ladder.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final int FIRST_CELL_INDEX = 0;

    private final List<Boolean> line = new ArrayList<>();
    private final BooleanGenerator generator;

    public Line(int countOfParticipants, BooleanGenerator generator) {
        this.generator = generator;

        createLine(countOfParticipants);
    }

    private void createLine(int countOfParticipants) {
        for (int cell = FIRST_CELL_INDEX; cell < countOfParticipants - 1; cell++) {
            createDiscontinuousLineAtCell(cell);
        }
    }

    private void createDiscontinuousLineAtCell(int cellIndex) {
        if (existLineAtLeftCell(cellIndex)) {
            line.add(Boolean.FALSE);
            return;
        }

        line.add(generator.generate());
    }

    private boolean existLineAtLeftCell(int cellIndex) {
        return cellIndex != FIRST_CELL_INDEX && line.get(cellIndex - 1);
    }

    public boolean existLineAtCell(int cellIndex){
        return line.get(cellIndex);
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(line);
    }

    public int size(){
        return line.size();
    }
}