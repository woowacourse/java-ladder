package laddergame.domain.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(final List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public Players(final Names names) {
        this(createPlayers(names.getNames()));

    }

    private static List<Player> createPlayers(final List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (int position = 0; position < playerNames.size(); position++) {
            players.add(Player.of(playerNames.get(position), position));
        }

        return players;
    }

    public Player findPlayerByPosition(final int position) {
        return players.stream()
                .filter(player -> player.getPosition() == position)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("해당되는 플레이어를 찾을 수 없습니다."));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getPlayerSize() {
        return players.size();
    }
}
