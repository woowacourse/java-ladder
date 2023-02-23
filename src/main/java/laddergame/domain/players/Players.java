package laddergame.domain.players;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import laddergame.domain.util.ExceptionMessageFormatter;

public class Players {

    private static final int MIN_PLAYER_COUNT = 2;

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(List<String> playerNames) {
        List<Player> players = playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        validate(players);
        return new Players(players);
    }

    private static void validate(List<Player> players) {
        if (players.size() < MIN_PLAYER_COUNT) {
            String message = String.format("참여자는 %d명 이상이어야 합니다.", MIN_PLAYER_COUNT);
            throw new IllegalArgumentException(ExceptionMessageFormatter.format(message, players.size()));
        }
        // TODO 중복 검사
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int indexOf(String name) {
        return IntStream.range(0, players.size())
                .filter(index -> Objects.equals(players.get(index).getName(), name))
                .findFirst()
                .orElseThrow(() -> {
                            throw new IllegalArgumentException(ExceptionMessageFormatter.format("참가자 이름이 존재하지 않습니다.", name));
                        }
                );
    }

    public int size() {
        return players.size();
    }
}
