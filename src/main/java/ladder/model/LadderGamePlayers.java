package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGamePlayers {

    private static final int EXIST_VALUE = 1;

    private List<LadderPlayer> ladderPlayers;

    public LadderGamePlayers(List<LadderPlayer> ladderPlayer) {
        this.ladderPlayers = ladderPlayer;
    }

    public List<String> getAlignedNames(int maxLenOfGoalNames) {
        return ladderPlayers.stream().map(ladderPlayer -> ladderPlayer.getAlignedName(maxLenOfGoalNames)).collect(Collectors.toList());
    }

    public int size() {
        return ladderPlayers.size();
    }

    public List<LadderPlayer> getAllPlayer() {
        return ladderPlayers;
    }

    public boolean existName(String targetName) {
        return ladderPlayers.stream().filter(ladderPlayer -> ladderPlayer.getPlayerName().equals(targetName)).count() == EXIST_VALUE;
    }
}
