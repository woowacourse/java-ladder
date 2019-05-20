package ladder.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LadderGamePlayers {
    private final List<LadderPlayer> ladderPlayers;

    public LadderGamePlayers(final List<LadderPlayer> players) {
        this.ladderPlayers = players;
    }

    public List<String> getAlignedNames() {
        return ladderPlayers.stream()
                .map(LadderPlayer::getAlignedName)
                .collect(toList());
    }

    public int size() {
        return ladderPlayers.size();
    }

    public List<String> getAllPlayerNames() {
        return ladderPlayers.stream()
                .map(LadderPlayer::getPlayerName)
                .collect(toList());
    }
}
