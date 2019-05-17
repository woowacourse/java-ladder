package ladder.domain;

import ladder.view.ConsoleMessages;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    public static final String FINISH_COMMAND = "all";
    private List<Player> players = new ArrayList<>();

    public Players(String inputName) {
        inputName = inputName.trim();
        if (inputName.equals("")) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_BLANK.message());
        }
        generatePlayer(validName(inputName));
    }

    private List<String> validName(String inputName) {
        List<String> names = Arrays.asList(inputName.split(","));
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
                    String name = names.get(i).trim();
                    if (name.isEmpty()) {
                        throw new IllegalArgumentException(ConsoleMessages.ERR_BLANK.message());
                    }
                    if (name.length() > 5) {
                        throw new IllegalArgumentException(ConsoleMessages.ERR_NAME_LENGTH.message());
                    }
                    if (name.equals(FINISH_COMMAND)) {
                        throw new IllegalArgumentException(ConsoleMessages.ERR_ILLEGAL_NAME.message());
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
                .filter(player -> player.name().equals(name.trim()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ConsoleMessages.ERR_NO_EXIST.message()));
    }

    public int count() {
        return players.size();
    }
}
