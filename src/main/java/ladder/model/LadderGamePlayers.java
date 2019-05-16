package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGamePlayers {

    private List<LadderPlayer> ladderPlayers;

    public LadderGamePlayers(List<LadderPlayer> players) {
        this.ladderPlayers = players;
    }

    public List<String> getAlignedNames() {
        return ladderPlayers.stream().map(LadderPlayer::getAlignedName).collect(Collectors.toList());
    }

    public int size() {
        return ladderPlayers.size();
    }
}
