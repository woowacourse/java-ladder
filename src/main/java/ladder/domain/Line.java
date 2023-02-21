package ladder.domain;

import ladder.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Line implements Iterable<Boolean> {
    private static final int FIRST_CELL_INDEX = 0;

    private final List<Boolean> line = new ArrayList<>();
    private final BooleanGenerator generator;

    public Line(int personCount, BooleanGenerator generator) {
        this.generator = generator;

        createLine(personCount);
    }

    private void createLine(int personCount) {
        for (int cell = FIRST_CELL_INDEX; cell < personCount - 1; cell++) {
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

    public List<Boolean> getLine() {
        return line;
    }

    @Override
    public Iterator<Boolean> iterator() {
        return line.iterator();
    }
}
