package ladder.domain.ladder;

import ladder.domain.ladder.line.Line;
import ladder.domain.ladder.line.LineDTO;
import ladder.domain.rule.LadderRule;
import ladder.domain.rule.RandomPointLadderRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MIN_LADDER_WIDTH = 2;

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int ladderHeight, int ladderWidth) {
        this(ladderHeight, ladderWidth, new RandomPointLadderRule());
    }

    public Ladder(int ladderHeight, int ladderWidth, LadderRule rule) {
        validateLadderSize(ladderHeight, ladderWidth);
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(ladderWidth, rule));
        }
    }

    private void validateLadderSize(int ladderHeight, int ladderWidth) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_LADDER_HEIGHT + " 이상입니다.");
        }
        if (ladderWidth < MIN_LADDER_WIDTH) {
            throw new IllegalArgumentException("사다리의 폭은 " + MIN_LADDER_WIDTH + " 이상입니다.");
        }
    }

    public List<LineDTO> getLineDTO() {
        return lines.stream().map(LineDTO::new).collect(Collectors.toList());
    }

    public int getEndPoint(int index) {
        int endPoint = index;
        for (Line line : lines) {
            endPoint = line.move(endPoint);
        }
        return endPoint;
    }
}
