package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGamePlayers {

    private static final int EXIST_VALUE = 1;

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

    public List<String> getAllPlayerNames() {
        return ladderPlayers.stream().map(LadderPlayer::getPlayerName).collect(Collectors.toList());
    }

    public boolean existName(String targetName) {
        return ladderPlayers.stream().filter(ladderPlayer -> ladderPlayer.getPlayerName().equals(targetName)).count() == EXIST_VALUE;
    }
}
