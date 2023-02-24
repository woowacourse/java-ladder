package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MINIMUM_PLAYERS_SIZE = 2;

    private final List<Player> players;

    private Players(List<Player> players) {
        validatePlayersSize(players);
        this.players = players;
    }

    public static Players generate(List<String> names) {
        List<Player> players = new ArrayList<>();
        int position = 0;
        for (String name : names) {
            players.add(new Player(name, position++));
        }
        return new Players(players);
    }

    private void validatePlayersSize(List<Player> names) {
        if (names.size() < MINIMUM_PLAYERS_SIZE) {
            throw new IllegalArgumentException("플레이어는 최소 2명 이상이여야 합니다");
        }
    }

    public void moveAll(Ladder ladder) {
        for (Player player : players) {
            player.move(ladder);
        }
    }

    public int findPositionBy(String name) {
        Player findPlayer = players.stream()
                .filter(player -> player.isMatchesBy(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름은 존재하지 않습니다."));
        return findPlayer.getPosition();
    }

    public int getSize() {
        return players.size();
    }

    public Player findBy(String name) {
        return players.stream()
                .filter(player -> player.isMatchesBy(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 Player가 없습니다"));
    }

    public List<String> getNameValues() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public List<Player> toUnmodifiablePlayers() {
        return Collections.unmodifiableList(players);
    }
}
