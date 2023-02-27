package domain.vo;

import domain.model.Players;

import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = List.copyOf(names);
    }

    public static Names from(List<String> input) {
        return new Names(toName(input));
    }

    private static List<Name> toName(List<String> input) {
        return input.stream()
                .map(Name::new)
                .collect(Collectors.toList());
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

    public Name get(int index) {
        return names.get(index);
    }

}
