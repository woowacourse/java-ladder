package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int peopleCount;
    private final int height;
    private final List<LadderLevel> ladderLevels;

    public Ladder(int peopleCount, int height) {
        validate(peopleCount);
        validate(height);
        this.peopleCount = peopleCount;
        this.height = height;
        ladderLevels = new ArrayList<>();
    }

    private void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
    }

    public void initialize(LineGenerator lineGenerator) {
        ladderLevels.clear();
        for (int i = 0; i < height; i++) {
            ladderLevels.add(new LadderLevel(peopleCount, lineGenerator));
        }
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public int getHeight() {
        return height;
    }

    public Direction getDirection(int height, int index) {
        LadderLevel ladderLevel = ladderLevels.get(height);
        return ladderLevel.getDirectionAt(index);
    }
}
