package ladder.domain;

import ladder.domain.connectiongenerator.ConnectionGenerator;
import ladder.domain.connectiongenerator.RandomConnectionGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MAX_LADDER_HEIGHT = 100;

    private final List<RowLine> rowLines;

    public Ladder(int height, int peopleNumber) {
        this(height, peopleNumber, new RandomConnectionGenerator());
    }

    public Ladder(int height, int peopleNumber, ConnectionGenerator connectionGenerator) {
        validateLadderHeight(height);
        this.rowLines = Stream.generate(() -> new RowLine(peopleNumber, connectionGenerator))
                .limit(height)
                .toList();
    }

    private void validateLadderHeight(int height) {
        if (height < MIN_LADDER_HEIGHT || height > MAX_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1이상 100이하여야 합니다");
        }
    }

    public List<RowLine> getRowLines() {
        return Collections.unmodifiableList(rowLines);
    }
}
