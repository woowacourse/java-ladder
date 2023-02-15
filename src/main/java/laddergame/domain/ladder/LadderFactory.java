package laddergame.domain.ladder;

import laddergame.domain.rung.Rungs;
import laddergame.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 10_000;
    private static final int DEFAULT_COUNT = 1;
    private final NumberGenerator rungNumberGenerator;

    public LadderFactory(final NumberGenerator rungNumberGenerator) {
        this.rungNumberGenerator = rungNumberGenerator;
    }

    public Ladder createLadder(final String height, final int participantCount) {
        int ladderHeight = convertLadderHeight(height);
        List<Rungs> ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
           ladder.add(new Rungs(makeRungCount(participantCount), rungNumberGenerator));
        }
        return new Ladder(ladder);
    }

    private int makeRungCount(final int participantCount) {
        return participantCount - DEFAULT_COUNT;
    }

    private int convertLadderHeight(final String height) {
        int ladderHeight = validateHeightType(height);
        validateHeightRange(ladderHeight);
        return ladderHeight;
    }

    private int validateHeightType(final String height) {
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 사다리 높이는 숫자를 입력해야 합니다.");
        }
    }

    private void validateHeightRange(final int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException("[ERROR] 사다리 높이는 1~10000 사이의 값만 가질 수 있습니다.");
        }
    }
}
