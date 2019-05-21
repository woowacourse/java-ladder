package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    static final int NAME_MIN_LENGTH = 1;
    static final int NAME_MAX_LENGTH = 5;

    private final List<String> players;

    public Players(List<String> playerNames) {
        players = Collections.unmodifiableList(
                playerNames.stream()
                        .map(String::trim)
                        .filter(name -> NAME_MIN_LENGTH <= name.length() && name.length() <= NAME_MAX_LENGTH)
                        .collect(Collectors.toList())
        );
        if (players.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public int getLongestPlayerNameLength() {
        return players.stream()
                    .mapToInt(String::length)
                    .max()
                    .getAsInt();
    }

    public List<String> getListOfPlayers() {
        return players;
    }

    public String get(int index) {
        return players.get(index);
    }

    public int number() {
        return players.size();
    }


    @Override
    public String toString() {
        String temp = players.toString();
        return temp.substring(1, temp.length() - 1);
    }
}