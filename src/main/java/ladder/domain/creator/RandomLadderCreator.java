package ladder.domain.creator;

import ladder.domain.Ladder;

import java.util.stream.IntStream;

public class RandomLadderCreator implements LadderCreator {
    private final RandomLineCreator randomLineCreator;

    public RandomLadderCreator(RandomLineCreator randomLineCreator) {
        this.randomLineCreator = randomLineCreator;
    }

    @Override
    public Ladder create(int width, int height) {
        return new Ladder(IntStream.range(0, height)
                .mapToObj(i -> randomLineCreator.create(width))
                .toList());
    }
}
