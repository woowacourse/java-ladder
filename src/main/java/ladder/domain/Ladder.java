package ladder.domain;

import ladder.domain.linegenerator.LineGenerator;
import ladder.domain.linegenerator.RandomLineGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MAX_LADDER_HEIGHT = 100;

    private final List<RowLine> rowLines;
    private final int peopleNumber;

    public Ladder(int height, int peopleNumber) {
        this(height, peopleNumber, new RandomLineGenerator());
    }

    public Ladder(int height, int peopleNumber, LineGenerator lineGenerator) {
        validateLadderHeight(height);
        this.peopleNumber = peopleNumber;

        List<RowLine> rowLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            rowLines.add(new RowLine(peopleNumber, lineGenerator));
        }
        this.rowLines = Collections.unmodifiableList(rowLines);
    }

    public List<RowLine> getRowLines() {
        return rowLines;
    }

    public int getResultOf(int lineNumber) {
        PositionRow positionRow = new PositionRow(lineNumber, peopleNumber);

        for (RowLine rowLine : rowLines) {
            rowLine.move(positionRow);
        }
        return positionRow.getPosition();
    }

    private void validateLadderHeight(int height) {
        if (height < MIN_LADDER_HEIGHT || height > MAX_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1이상 100이하여야 합니다");
        }
    }
}
