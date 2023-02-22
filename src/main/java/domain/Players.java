package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

    public static final int MAX_SIZE = 10;
    public static final int MIN_SIZE = 2;
    public static final String INVALID_NAMES_SIZE_ERROR_MESSAGE = "최소 " + MIN_SIZE + "명이상 최대 " + MAX_SIZE + "명 이하 참가자가 필요합니다.";
    public static final String DUPLICATED_ERROR_MESSAGE = "중복된 사람은 참여할 수 없습니다.";
    public static final String NOT_SAVED_PARTICIPANT_ERROR_MESSAGE = "등록되지 않은 참가자 이름입니다";

    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = players;
    }

    public static Players of(final List<Player> players) {
        validateNames(players);
        return new Players(players);
    }

    public static Players ofValues(final List<String> nameValues) {
        List<Player> players = Player.ofMultiple(nameValues);
        validateNames(players);
        return new Players(players);
    }

    private static void validateNames(final List<Player> players) {
        validateNamesSize(players);
        validateDuplicated(players);
    }

    private static void validateNamesSize(final List<Player> players) {
        if (players.size() < MIN_SIZE || players.size() > MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_NAMES_SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicated(final List<Player> players) {
        players.forEach(target -> {
            if (hasDuplication(players, target)) {
                throw new IllegalArgumentException(DUPLICATED_ERROR_MESSAGE);
            }
        });
    }

    private static boolean hasDuplication(final List<Player> players, Player target) {
        return (Collections.frequency(players, target) > 1);
    }

    public int count() {
        return this.players.size();
    }

    public List<String> getNames() {
        List<String> names = this.players.stream()
                .map(Player::getValue)
                .collect(Collectors.toList());

        return List.copyOf(names);
    }

    @Override
    public boolean equals(Object names) {
        if (this == names) return true;
        if (names == null || getClass() != names.getClass()) return false;
        Players anotherPlayers = (Players) names;
        return this.players.equals(anotherPlayers.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        return "Names{" +
                "names=" + players +
                '}';
    }

    public int getSequenceOf(String name) {
        int sequence = players.indexOf(Player.of(name));
        if (sequence == -1) {
            throw new IllegalArgumentException(NOT_SAVED_PARTICIPANT_ERROR_MESSAGE);
        }
        return sequence;
    }
}
