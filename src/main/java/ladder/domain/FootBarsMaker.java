package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import ladder.util.BooleanGenerator;

public class FootBarsMaker {
    private static final int FIRST_CELL_INDEX = 0;

    public static FootBars makeFootBars(BooleanGenerator generator, int numberOfPeople) {
        List<Boolean> footBars = new ArrayList<>();
        for (int cell = FIRST_CELL_INDEX; cell < numberOfPeople - 1; cell++) {
            makeFootBar(generator, footBars, cell);
        }
        return new FootBars(footBars);
    }

    private static void makeFootBar(BooleanGenerator generator, List<Boolean> footBars, int index) {
        if (existLineAtLeftCell(footBars, index)) {
            footBars.add(Boolean.FALSE);
            return;
        }

        footBars.add(generator.generate());
    }

    private static boolean existLineAtLeftCell(List<Boolean> footBars, int cellIndex) {
        return cellIndex != FIRST_CELL_INDEX && footBars.get(beforeIndexOf(cellIndex));
    }

    private static int beforeIndexOf(int index) {
        return index - 1;
    }

}
