package laddergame.domain.ladder;

import laddergame.domain.connectiongenerator.ConnectionGenerator;
import laddergame.domain.connectiongenerator.RandomConnectionGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final List<RowLine> rowLines;
    private final Height height;

    public Ladder(int height, int peopleNumber) {
        this(height, peopleNumber, new RandomConnectionGenerator());
    }

    public Ladder(int height, int peopleNumber, ConnectionGenerator connectionGenerator) {
        this.height = new Height(height);
        this.rowLines = Stream.generate(() -> new RowLine(peopleNumber, connectionGenerator))
                .limit(this.height.getHeight())
                .toList();
    }

    public List<Integer> move(int peopleNumber) {
        List<Integer> playerPositions = IntStream.range(0, peopleNumber)
                .boxed()
                .toList();

        for (RowLine rowLine : rowLines) {
            playerPositions = rowLine.move(playerPositions);
        }

        return playerPositions;
    }

    public List<RowLine> getRowLines() {
        return Collections.unmodifiableList(rowLines);
    }
}
