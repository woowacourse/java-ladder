package ladder.domain;

import ladder.domain.connectiongenerator.ConnectionGenerator;
import ladder.domain.connectiongenerator.RandomConnectionGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private final List<RowLine> rowLines;
    Height height;

    public Ladder(int height, int peopleNumber) {
        this(height, peopleNumber, new RandomConnectionGenerator());
    }

    public Ladder(int height, int peopleNumber, ConnectionGenerator connectionGenerator) {
        this.height = new Height(height);
        this.rowLines = Stream.generate(() -> new RowLine(peopleNumber, connectionGenerator))
                .limit(this.height.getHeight())
                .toList();
    }

    public List<RowLine> getRowLines() {
        return Collections.unmodifiableList(rowLines);
    }
}
