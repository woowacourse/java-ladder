package ladder.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Players {
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 13;

    private final List<Player> players;

    public Players(String[] names) {
        trimNames(names);
        validate(names);
        this.players = create(names);
    }

    private List<Player> create(String[] names) {
        return Arrays.stream(names)
                .map(Player::new)
                .collect(toList());
    }

    private void trimNames(String[] names) {
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }
    }

    private void validate(String[] names) {
        validateSize(names);
        validateDuplicate(names);
    }

    private void validateSize(String[] names) {
        if (isProper(names)) {
            throw new IllegalArgumentException("[ERROR] 사용자는 2명에서 13명까지 가능합니다.");
        }
    }

    private boolean isProper(String[] names) {
        return MAX_PLAYERS < names.length || names.length < MIN_PLAYERS;
    }

    private void validateDuplicate(String[] names) {
        long uniqueNamesLength = Arrays.stream(names)
                .distinct()
                .count();
        if (uniqueNamesLength != names.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다.");
        }
    }

    public int findPosition(String playerName) {
        Player findPlayer = findPlayer(playerName);
        return players.indexOf(findPlayer);
    }

    private Player findPlayer(String playerName) {
        return players.stream()
                .filter(player -> player.hasName(playerName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하는 참가자의 이름을 입력해주세요."));
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(toList());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getPlayersCount() {
        return players.size();
    }
}
