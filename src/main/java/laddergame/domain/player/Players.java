package laddergame.domain.player;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Players {

    private final List<Player> players;

    public Players(final List<Player> players) {
        this.players = players;
    }

    public Players(final Names names) {
        this(createPlayers(names.getNames()));

    }

    private static List<Player> createPlayers(final List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (int position = 0; position < playerNames.size(); position++) {
            players.add(Player.of(playerNames.get(position) ,position));
        }

        return players;
    }

    public Player findPlayerByName(final String name) {
        return players.stream()
                .filter(player -> player.equalName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 플레이어가 없습니다."));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Names findPlayerNames() {
        return new Names(players.stream()
                .map(Player::getName)
                .collect(toList()));
    }

    public Player findPlayerByPosition(final int position) {
        return players.stream()
                .filter(player -> player.getPosition() == position)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("해당되는 플레이어를 찾을 수 없습니다."));
    }

    public int getPlayerSize() {
        return players.size();
    }

    public Player getPlayer(final int index) {
        return players.get(index);
    }
}
