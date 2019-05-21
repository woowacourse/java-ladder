package ladder.domain;

import ladder.view.ConsoleMessages;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private List<Player> players = new ArrayList<>();

    public Players(List<String> names) {
        generatePlayer(valid(names));
    }

    private List<String> valid(List<String> names) {
        if (names.size() == 0) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_BLANK.message());
        }
        if (names.size() < 2) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_LADDER_RANGE.message());
        }
        Set<String> checkSet = new HashSet<>(names);
        if (names.size() != checkSet.size()) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_DUPLICATE.message());
        }
        return names;
    }

    private void generatePlayer(List<String> names) {
        players = IntStream.range(0, names.size())
                .mapToObj(i -> {
                    return new Player(names.get(i), i);
                })
                .collect(Collectors.toList());
    }

    public List<Player> list() {
        return players;
    }

    public Player player(String name) {
        return players.stream()
                .filter(player -> player.name().equals(name.trim()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ConsoleMessages.ERR_NO_EXIST.message()));
    }

    public int count() {
        return players.size();
    }
}
