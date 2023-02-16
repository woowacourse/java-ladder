package domain;

import java.util.ArrayList;
import java.util.List;
import utils.RandomFootholdGenerator;

public class Lines {

    private final List<Line> lines;

    public Lines(final int numberOfPlayer, final int height) {
        this.lines = makeLines(numberOfPlayer, height);
    }

    private List<Line> makeLines(final int numberOfPlayer, final int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(numberOfPlayer, new RandomFootholdGenerator()));
        }

        return lines;
    }

    public List<Boolean> findSelectedLine(final int selectedPosition) {
        return this.lines.get(selectedPosition).getFootholds();
    }

    public List<Line> getLines() {
        return lines;
    }
}
