package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players = new ArrayList<>();

    public Players(List<Name> names) {
        names.stream()
                .map(Player::new)
                .forEach(players::add);

//        IntStream.range(0, names.size()).forEach(index ->
//                players.add(new Player(names.getName(index)))
//        );
    }

    public int size() {
        return players.size();
    }

    public List<String> getAllPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
}
