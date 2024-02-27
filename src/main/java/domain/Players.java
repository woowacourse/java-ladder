package domain;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private final List<Name> players;

    public Players (List<String> names) {
        validateNumber(names);
        this.players = names.stream()
                .map(Name::new)
                .toList();
    }

    public List<Name> getPlayers() {
        return new ArrayList<>(players);
    }

    private void validateNumber(List<String> names) {
        if (names.size() < 2 || names.size() > 10){
            throw new IllegalArgumentException("이름의 수는 2이상 10이하여야 합니다.");
        }
    }
}
