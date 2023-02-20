package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Name> names;

    public Players(List<String> names) {
        this.names = names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Name> getPlayers() {
        return names;
    }

    public int getPlayerSize() {
        return names.size();
    }
}
