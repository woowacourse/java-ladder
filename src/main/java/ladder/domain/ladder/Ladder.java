package ladder.domain.ladder;

import ladder.domain.rule.LadderRule;
import ladder.domain.rule.RandomPointLadderRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private List<Line> lines = new ArrayList<>();

    public Ladder(int ladderHeight, int countPerson) {
        this(ladderHeight, countPerson, new RandomPointLadderRule());
    }

    public Ladder(int ladderHeight, int countPerson, LadderRule rule) {
        validateLadderHeight(ladderHeight);
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(countPerson, rule));
        }
    }

    private void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException();
        }
    }
    public List<LineDTO> getLineDTO() {
        return lines.stream().map(LineDTO::new).collect(Collectors.toList());
    }

    public int getEndPoint(int index) {
        int endPoint = index;
        for(Line line : lines) {
            endPoint = line.move(endPoint);
        }
        return endPoint;
    }

}
