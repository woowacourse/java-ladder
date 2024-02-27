package domain;

import java.util.Iterator;
import java.util.List;

public class Players implements Iterable<Name> {

    private final List<Name> players;

    public Players (List<String> names) {
        validateNumber(names);
        this.players = names.stream()
                .map(Name::new)
                .toList();
    }

    public int getPersonCount() {
        return players.size();
    }

    private void validateNumber(List<String> names) {
        if (names.size() < 2 || names.size() > 10){
            throw new IllegalArgumentException("이름의 수는 2이상 10이하여야 합니다.");
        }
    }

    @Override
    public Iterator<Name> iterator() {
        return players.iterator();
    }
}
