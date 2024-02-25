package laddergame.domain.player;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Players {

    private final List<Player> names;

    public Players(final List<String> input) {
        final List<Player> names = convertToNames(input);
        validateDuplication(names);

        this.names = names;
    }

    private List<Player> convertToNames(final List<String> input) {
        return input.stream()
                .map(Player::new)
                .toList();
    }

    private void validateDuplication(final List<Player> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException("[ERROR] 이름은 중복 될 수 없습니다.");
        }
    }

    public int getSize() {
        return names.size();
    }

    public Player getName(int index) {
        return this.names.get(index);
    }

    public List<Player> getNames() {
        return Collections.unmodifiableList(names);
    }
}
