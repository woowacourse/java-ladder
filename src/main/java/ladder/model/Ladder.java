package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private List<LadderWidth> ladder = new ArrayList<>();

    public Ladder(List<Player> players, LadderHeight height){
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.add(new LadderWidth(players.size() - 1));
        }
    }

    @Override
    public String toString() {
        return ladder.stream().map(LadderWidth::toString).collect(Collectors.joining("\n"));
    }
}
