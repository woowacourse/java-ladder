package domain.player;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private static final int MIN_PLAYER_SIZE = 2;
    private static final int MAX_PLAYER_SIZE = 50;

    private final List<Player> players;
    private final List<Name> playersName;

    public Players(List<String> playersName) {
        validateDuplicate(playersName);
        validateSize(playersName);
        this.players = createPlayers(playersName);
        this.playersName = playersName.stream()
                .map(Name::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Player> createPlayers(List<String> playersName) {
        return IntStream.range(0, playersName.size())
                .mapToObj(i -> new Player(playersName.get(i), i))
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateDuplicate(List<String> playersName) {
        Set<String> uniqueNames = new HashSet<>(playersName);

        if (uniqueNames.size() != playersName.size()) {
            throw new IllegalArgumentException("게임 참여자의 이름은 중복될 수 없습니다.");
        }
    }

    private void validateSize(List<String> playersName) {
        if (playersName.size() < MIN_PLAYER_SIZE || playersName.size() > MAX_PLAYER_SIZE) {
            throw new IllegalArgumentException("게임 참여자 수는 최소 2명 최대 50명까지 가능합니다.");
        }
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<Name> getPlayersName() {
        return playersName;
    }
}
