package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.RandomNumberGenerator;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(PlayerNumber playerNumber, Height height) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, playerNumber.getLineNumber())
                .forEach(it -> lines.add(Line.fromHeight(height)));

        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
