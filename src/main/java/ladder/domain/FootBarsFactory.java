package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import ladder.util.BooleanGenerator;

public class FootBarsFactory {
    private static final int FIRST_CELL_INDEX = 0;

    public static FootBars newFootBars(BooleanGenerator generator, int numberOfPeople) {
        List<Boolean> footBars = new ArrayList<>();
        for (int cell = FIRST_CELL_INDEX; cell < numberOfPeople - 1; cell++) {
            footBars.add(createFootBar(generator, footBars, cell));
        }
        return new FootBars(footBars);
    }

    private static Boolean createFootBar(BooleanGenerator generator, List<Boolean> footBars, int index) {
        if (FootBars.existLineAtLeftCell(footBars, index)) {
            return Boolean.FALSE;
        }
        return generator.generate();
    }
}
