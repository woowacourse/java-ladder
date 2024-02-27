package laddergame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static laddergame.domain.Player.NAME_BLANK_ERROR;

public class Players {
    private static final String NAME_DUPLICATED_ERROR = "이름의 중복은 허용하지 않습니다.";
    private static final String NAMES_COUNT_ERROR = "이름을 두명 이상 적어주세요.";
    private static final int MIN_NAMES_COUNT = 2;

    private final List<Player> players;

    public Players(final List<String> playerNames) {
        validate(playerNames);
        this.players = IntStream.range(0, playerNames.size())
                .mapToObj(i -> new Player(playerNames.get(i), new Position(i, 0)))
                .toList();
    }

    public String findItemByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player.getItem();
            }
        }
        throw new IllegalArgumentException("이름 없음");
    }

    private void validate(final List<String> playerNames) {
        checkBlankName(playerNames);
        checkDuplicated(playerNames);
        checkNamesCount(playerNames.size());
    }

    private void checkDuplicated(List<String> playerNames) {
        if (hasDuplicateName(playerNames)) {
            throw new IllegalArgumentException(NAME_DUPLICATED_ERROR);
        }
    }

    private void checkBlankName(List<String> playerNames) {
        if (playerNames.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR);
        }
    }

    private void checkNamesCount(int count) {
        if (count < MIN_NAMES_COUNT) {
            throw new IllegalArgumentException(NAMES_COUNT_ERROR);
        }
    }

    private boolean hasDuplicateName(final List<String> carNames) {
        return carNames.size() != getDistinctNamesCount(carNames);
    }

    private long getDistinctNamesCount(final List<String> playerNames) {
        return playerNames.stream()
                .distinct()
                .count();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getPlayersCount() {
        return players.size();
    }
}
