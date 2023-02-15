package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ladder.util.BooleanGenerator;

public class Line implements Iterable<Boolean> {
    private static final int FIRST_CELL_INDEX = 0;

    private final List<Boolean> line = new ArrayList<>();
    private final BooleanGenerator generator;

    public Line(int personCount, BooleanGenerator generator) {
        this.generator = generator;

        createLine(personCount);
    }

    public List<Boolean> getLine() {
        return line;
    }

    private void createLine(int personCount) {
        for (int cell = FIRST_CELL_INDEX; cell < personCount - 1; cell++) {
            createLineAtCell(cell);
        }
    }

    private void createLineAtCell(int cellIndex) {
        if (existLineAtLeftCell(cellIndex)) {
            line.add(Boolean.FALSE);
            return;
        }

        line.add(generator.generate());
    }

    private boolean existLineAtLeftCell(int cellIndex) {
        return cellIndex != FIRST_CELL_INDEX && line.get(cellIndex - 1);
    }

    @Override
    public Iterator<Boolean> iterator() {
        return line.iterator();
    }
}
