package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final Players players;
    private final Height height;
    private final List<LadderLevel> ladderLevels;

    public Ladder(Players players, Height height) {
        this.players = players;
        this.height = height;
        ladderLevels = new ArrayList<>();
    }

    public void initialize(LineGenerator lineGenerator) {
        ladderLevels.clear();
        for (int currentHeight = 0; currentHeight < height.value(); currentHeight++) {
            ladderLevels.add(new LadderLevel(players.count(), lineGenerator));
        }
    }

    public List<LadderLevel> toLadderLevelList() {
        return Collections.unmodifiableList(ladderLevels);
    }
}
