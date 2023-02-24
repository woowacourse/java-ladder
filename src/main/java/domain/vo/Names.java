package domain.vo;

import domain.model.Player;
import domain.model.Players;

import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public boolean contains(Name name) {
        return names.contains(name);
    }

    public int size() {
        return names.size();
    }

    public List<Integer> orderByName(Players players) {
        return names.stream()
                .map(players::orderByName)
                .collect(Collectors.toList());
    }

    public List<String> mapToString() {
        return names.stream()
                .map(Name::getValue)
                .collect(Collectors.toList());
    }

    public List<Player> mapToPlayers() {
        return names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public Name get(int index) {
        return names.get(index);
    }

}
