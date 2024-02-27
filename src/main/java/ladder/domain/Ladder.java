package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderLevel> ladder;

    public Ladder(List<LadderLevel> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(Players players, Height height, LadderDirectionSelector ladderDirectionSelector) {
        List<LadderLevel> ladder = new ArrayList<>();
        IntStream.range(0, height.value()).forEach(
                __ -> ladder.add(LadderLevelBuilder.builder()
                        .size(players.count())
                        .directionSelector(ladderDirectionSelector)
                        .build())
        );
        return new Ladder(ladder);
    }

    public List<LadderLevel> getLadderLevels() {
        return Collections.unmodifiableList(ladder);
    }
}
