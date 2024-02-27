package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Ladder {
    private final List<Paths> paths;

    private Ladder(final List<Paths> paths) {
        this.paths = paths;
    }

    public static Ladder of(Supplier<Boolean> randomGenerator, LadderHeight ladderHeight, int playersCount) {
        List<Paths> paths = new ArrayList<>();
        for (int floor = 1; floor <= ladderHeight.ladderHeight(); floor++) {
            paths.add(Paths.init(randomGenerator, playersCount - 1));
        }

        System.out.println(paths.toString());
        return new Ladder(paths);
    }
}
