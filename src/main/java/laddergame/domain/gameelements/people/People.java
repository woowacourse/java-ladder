package laddergame.domain.gameelements.people;

import laddergame.domain.gameelements.Elements;

import java.util.Collections;
import java.util.List;

public class People extends Elements {
    private final List<Name> names;

    public People(List<String> names) {
        super(names);
        this.names = names.stream()
                .map(Name::new)
                .toList();
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
