package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Players {
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 13;

    private final List<Player> players;

    public Players(List<Player> players) {
        validateSize(players);
        validateDuplicate(players);
        this.players = players;
    }

    public void validateSize(List<Player> players) {
        if (isProper(players)) {
            throw new IllegalArgumentException("[ERROR] 사용자는 2명에서 13명까지 가능합니다.");
        }
    }

    private boolean isProper(List<Player> players) {
        return MAX_PLAYERS < players.size() || players.size() < MIN_PLAYERS;
    }

    private void validateDuplicate(List<Player> players) {
        long uniquePlayersCount = players.stream()
                .distinct()
                .count();
        if (uniquePlayersCount != players.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다.");
        }
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getPlayersCount() {
        return players.size();
    }

    public int findIndexByPlayerName(String PlayerName) {
        Player foundPlayer = players.stream()
                .filter(player -> player.isNameMatch(PlayerName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 참여자가 없습니다."));
        return players.indexOf(foundPlayer);
    }
}
