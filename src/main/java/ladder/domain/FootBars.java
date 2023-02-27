package ladder.domain;

import java.util.Collections;
import java.util.List;

import ladder.util.BooleanGenerator;

public class FootBars {
    private static final int FIRST_CELL_INDEX = 0;
    private final List<Boolean> footBars;

    public FootBars(List<Boolean> footBars) {
        this.footBars = footBars;
    }

    public void createFootBars(BooleanGenerator generator, int numberOfPeople) {
        for (int cellIndex = 0; cellIndex < numberOfLadderCells(numberOfPeople); cellIndex++) {
            footBars.add(createFootBar(generator, cellIndex));
        }
    }

    private int numberOfLadderCells(int numberOfPeople) {
        return numberOfPeople - 1;
    }

    private Boolean createFootBar(BooleanGenerator generator, int cellIndex) {
        if (existLineAtLeftCell(cellIndex)) {
            return Boolean.FALSE;
        }
        return generator.generate();
    }

    private boolean existLineAtLeftCell(int cellIndex) {
        return cellIndex != FIRST_CELL_INDEX && footBars.get(cellIndex - 1);
    }

    public List<Boolean> getFootBars() {
        return Collections.unmodifiableList(footBars);
    }
}
