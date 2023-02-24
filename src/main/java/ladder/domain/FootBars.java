package ladder.domain;

import java.util.List;

public class FootBars {
    private final List<Boolean> footBars;

    public FootBars(List<Boolean> footBars) {
        this.footBars = footBars;
    }

    private static int beforeIndexOf(int index) {
        return index - 1;
    }

    public static boolean existLineAtLeftCell(List<Boolean> footBars, int cellIndex) {
        return cellIndex != 0 && footBars.get(beforeIndexOf(cellIndex));
    }

    public List<Boolean> getFootBars() {
        return footBars;
    }

}
