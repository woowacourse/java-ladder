package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import ladder.util.BooleanGenerator;

public class FootBarsFactory {
    private static final int FIRST_CELL_INDEX = 0;

    public static FootBars newFootBars(BooleanGenerator generator, int numberOfPeople) {
        List<Boolean> footBars = new ArrayList<>();
        for (int cell = FIRST_CELL_INDEX; cell < numberOfPeople - 1; cell++) {
            makeFootBar(generator, footBars, cell);
        }
        return new FootBars(footBars);
    }

    private static void makeFootBar(BooleanGenerator generator, List<Boolean> footBars, int index) {
        if (FootBars.existLineAtLeftCell(footBars, index)) {
            footBars.add(Boolean.FALSE);
            return;
        }

        footBars.add(generator.generate());
    }
}
