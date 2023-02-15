package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {
    private final int height;
    private final List<Ladder> ladders;
    private final RandomGenerator randomGenerator;

    public Ladders(int height, RandomGenerator randomGenerator) {
        if (height < 1 || height > 10) {
            throw new IllegalArgumentException("사다리 높이는 1에서 10");
        }
        this.height = height;
        this.ladders = new ArrayList<>();
        this.randomGenerator = randomGenerator;
    }

    public void make(int width) {
        for (int index = 0; index < height; index++) {
            ladders.add(new Ladder(randomGenerator.generateLadder(width)));
        }
    }

    public List<Ladder> getLadders() {
        return new ArrayList<>(ladders);
    }
}
