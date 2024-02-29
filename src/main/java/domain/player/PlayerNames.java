package domain.player;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNames {
    private static final Integer MINIMUM_SIZE = 2;
    private final List<PlayerName> playerNames;

    public PlayerNames(List<String> names) {
        validate(names);
        this.playerNames = fromNameStrings(names);
    }

    private List<PlayerName> fromNameStrings(List<String> names) {
        return names.stream()
                .map(PlayerName::new)
                .toList();
    }

    private void validate(List<String> names) {
        validateSize(names);
        validateDuplicated(names);
    }

    private void validateDuplicated(List<String> names) {
        Set<String> duplicateSize = new HashSet<>(names);
        if (duplicateSize.size() != names.size()) {
            throw new IllegalArgumentException("중복된 이름이 포함되어 있습니다.");
        }
    }

    private void validateSize(List<String> names) {
        if (names.size() < MINIMUM_SIZE) {
            throw new IllegalArgumentException("최소 2 명 이상의 이름을 입력해주세요.");
        }
    }

    public List<PlayerName> getValue() {
        return Collections.unmodifiableList(playerNames);
    }
}
