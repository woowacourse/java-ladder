package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private List<LadderWidth> ladder = new ArrayList<>();

    public Ladder(LadderGamePlayers players, int height) {
        for (int i = 0; i < height; i++) {
            ladder.add(new LadderWidth(players.size() - 1));
        }
    }

    @Override
    public String toString() {
        return ladder.stream().map(LadderWidth::toString).collect(Collectors.joining("\n"));
    }
}
