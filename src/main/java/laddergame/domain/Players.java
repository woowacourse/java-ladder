package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Players {
    private static final int MIN_PLAYER_COUNT = 2;
    private static final int FIRST_PLAYER = 0;

    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = players;
    }

    public static Players from(final List<String> names) {
        validatePlayerCount(names);
        final List<Player> players = createPlayers(names);
        return new Players(players);
    }

    public int findMaxNameLength() {
        return players.stream()
                .mapToInt(Player::getNameLength)
                .max()
                .orElseThrow(() -> new IllegalStateException("가장 긴 이름을 찾을 수 없습니다."));
    }

    public void sortPlayersByPosition() {
        Collections.sort(players, Comparator.comparingInt(Player::getOrder));
    }

    private static List<Player> createPlayers(final List<String> names) {
        final int playerCount = names.size();
        final List<Name> playerNames = createNames(names);
        final List<Position> playerPositions = createPosition(playerCount);

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            players.add(new Player(playerNames.get(i), playerPositions.get(i)));
        }
        return players;
    }

    private static List<Name> createNames(final List<String> names) {
        return names.stream()
                .map(name -> new Name(name.trim()))
                .collect(toList());
    }

    private static List<Position> createPosition(final int playerCount) {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            positions.add(Position.of(i, playerCount));
        }
        return positions;
    }

    private static void validatePlayerCount(final List<String> names) {
        if (names.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("최소 2명 이상의 플레이어가 필요합니다.");
        }
    }

    public int getFirstNameLength() {
        return players.get(FIRST_PLAYER).getNameLength();
    }

    public List<String> getPlayerName() {
        return players.stream()
                .map(Player::getName)
                .collect(toList());
    }

    public int getSize() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }
}
