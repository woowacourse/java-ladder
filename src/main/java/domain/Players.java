package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    static final String ERROR_DUPLICATED_NAME = "참가자의 이름은 중복될 수 없습니다.";
    static final String ERROR_MIN_PLAYER_COUNT = "참여자 수는 2명 이상이어야 합니다.";
    private static final int MIN_PLAYER_COUNT = 2;
    private final List<Player> players = new ArrayList<>();

    public Players(List<String> names) {
        validateDuplicatedNames(names);
        validateMinPlayerCount(names);
        preparePlayers(names);
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_NAME);
        }
    }

    private void validateMinPlayerCount(List<String> names) {
        if (names.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(ERROR_MIN_PLAYER_COUNT);
        }
    }

    private void preparePlayers(List<String> names) {
        for (String name : names) {
            players.add(new Player(name));
        }
    }

    public int findPositionOfPlayer(String name) {
        return players.indexOf(findPlayerByName(name));
    }

    private Player findPlayerByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("참여자 목록에 없는 이름입니다."));
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
