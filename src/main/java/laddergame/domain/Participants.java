package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Name> names;

    public Participants(List<Name> names) {
        if (names == null) {
            throw new IllegalArgumentException();
        }
        if (names.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.names = names;
    }

    public int getSize() {
        return names.size();
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::getValue)
                .collect(Collectors.toUnmodifiableList());
    }
}
