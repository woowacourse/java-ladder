package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final int playerCount, final int height) {
        ArrayList<Line> list = new ArrayList<>();
        IntStream.range(0, height)
                .forEach(i -> list.add(new Line(playerCount)));
        this.lines = list;
    }

    public List<Line> getLines() {
        return lines;
    }
}
