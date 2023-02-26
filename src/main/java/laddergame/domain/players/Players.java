package laddergame.domain.players;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import laddergame.util.ExceptionMessageFormatter;

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
        validateCount(players.size());
        validateDuplicated(players);
    }

    private static void validateCount(int playerCount) {
        if (playerCount < MIN_PLAYER_COUNT) {
            String message = String.format("참여자는 %d명 이상이어야 합니다.", MIN_PLAYER_COUNT);
            throw new IllegalArgumentException(ExceptionMessageFormatter.format(message, playerCount));
        }
    }

    private static void validateDuplicated(List<Player> players) {
        List<String> duplicatedNames = findDuplicatedNames(players);
        if (duplicatedNames.size() != 0) {
            String message = "참여자 간 이름은 중복되지 않아야 합니다.";
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.format(message, String.join(",", duplicatedNames)));
        }
    }

    private static List<String> findDuplicatedNames(List<Player> players) {
        Set<Player> checker = new HashSet<>();
        return players.stream()
                .filter(player -> !(checker.add(player)))
                .map(Players::getNameByPlayer)
                .collect(Collectors.toList());
    }

    private static String getNameByPlayer(Player player) {
        return player.getName().getValue();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Players::getNameByPlayer)
                .collect(Collectors.toList());
    }

    public int indexOf(Name name) {
        String nameValue = name.getValue();
        return IntStream.range(0, players.size())
                .filter(index -> Objects.equals(getNameByPlayer(players.get(index)), nameValue))
                .findFirst()
                .orElseThrow(() -> {
                            throw new IllegalArgumentException(
                                    ExceptionMessageFormatter.format("참가자 이름이 존재하지 않습니다.", nameValue));
                        }
                );
    }

    public int size() {
        return players.size();
    }

    public List<Player> players() {
        return new ArrayList<>(players);
    }
}
