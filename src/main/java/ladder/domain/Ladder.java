package ladder.domain;

import ladder.domain.linegenerator.LineGenerator;
import ladder.domain.linegenerator.RandomLineGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MAX_LADDER_HEIGHT = 100;

    private final List<RowLine> rowLines = new ArrayList<>();

    public Ladder(int height, int peopleNumber) {
        this(height, peopleNumber, new RandomLineGenerator());
    }

    //TODO Stream.generate 고민하기
    public Ladder(int height, int peopleNumber, LineGenerator lineGenerator) {
        validateLadderHeight(height);

        for (int i = 0; i < height; i++) {
            this.rowLines.add(new RowLine(peopleNumber, lineGenerator));
        }
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
