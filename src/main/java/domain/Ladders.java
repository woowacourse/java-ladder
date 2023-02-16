package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {
    private static final int LADDER_MIN_HEIGHT = 1;
    private static final int LADDER_MAX_HEIGHT = 10;
    private static final String INVALID_LADDER_HEIGHT_MESSAGE = "사다리 높이는 1~10 사이 정수만 가능합니다.";
    private final int height;
    private final List<Ladder> ladders;
    private final LadderGenerator ladderGenerator;

    public Ladders(int height, LadderGenerator ladderGenerator) {
        validateLadderHeight(height);
        this.height = height;
        this.ladders = new ArrayList<>();
        this.ladderGenerator = ladderGenerator;
    }

    private void validateLadderHeight(int height) {
        if (height < LADDER_MIN_HEIGHT || height > LADDER_MAX_HEIGHT) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_MESSAGE);
        }
    }

    public void make(int width) {
        for (int floor = 0; floor < height; floor++) {
            ladders.add(new Ladder(ladderGenerator.generateLadder(width)));
        }
    }

    public List<Ladder> getLadders() {
        return new ArrayList<>(ladders);
    }
}
