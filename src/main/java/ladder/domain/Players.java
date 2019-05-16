package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private List<Player> players = new ArrayList<>();

    public Players(String inputName) {
        inputName = inputName.trim();
        if (inputName.equals("")) {
            throw new IllegalArgumentException();
        }
        generatePlayer(validName(inputName));
    }

    private List<String> validName(String inputName) {
        List<String> names = Arrays.asList(inputName.split(","));
        if (names.size() < 2) {
            throw new IllegalArgumentException();
        }
        Set<String> checkSet = new HashSet<>(names);
        if (names.size() != checkSet.size()) {
            throw new IllegalArgumentException();
        }
        return names;
    }

    private void generatePlayer(List<String> names) {
        players = IntStream.range(0, names.size())
                .mapToObj(i -> {
                    String name = names.get(i).trim();
                    if (name.isEmpty()) {
                        throw new IllegalArgumentException();
                    }
                    if (name.length() > 5) {
                        throw new IllegalArgumentException();
                    }
                    return new Player(name, i);
                })
                .collect(Collectors.toList());
    }

    public List<Player> list() {
        return players;
    }

    public Player player(String name) {
        return players.stream()
                .filter(player -> player.name().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int count() {
        return players.size();
    }
}
