package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGamePlayers {

    private List<LadderPlayer> ladderPlayers;

    public LadderGamePlayers(List<LadderPlayer> players) {
        this.ladderPlayers = players;
    }

    public List<String> getAlignedNames(int maxLenOfGoalNames) {
        return ladderPlayers.stream().map(player -> player.getAlignedName(maxLenOfGoalNames)).collect(Collectors.toList());
    }

    public int size() {
        return ladderPlayers.size();
    }
}
