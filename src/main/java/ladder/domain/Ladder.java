package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {

    private final People people;
    private final Height height;
    private final List<LadderLevel> ladderLevels;

    public Ladder(People people, Height height) {
        this.people = people;
        this.height = height;
        ladderLevels = new ArrayList<>();
    }

    public void initialize(LineGenerator lineGenerator) {
        ladderLevels.clear();
        for (int currentHeight = 0; currentHeight < height.value(); currentHeight++) {
            ladderLevels.add(new LadderLevel(people.count(), lineGenerator));
        }
    }

    public Stream<LadderLevel> stream() {
        return ladderLevels.stream();
    }
}
