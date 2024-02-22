package domain.player;

import java.util.List;

public class PlayerNames {
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복된 이름이 존재합니다.";

    private final List<PlayerName> names;

    public PlayerNames(final List<PlayerName> names) {
        validateDuplicateName(names);
        this.names = names;
    }

    private void validateDuplicateName(List<PlayerName> names) {
        if (getUniqueNamesSize(names) != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private long getUniqueNamesSize(final List<PlayerName> names) {
        return names.stream()
                .distinct()
                .count();
    }

    public int findMaxNameLength() {
        return names.stream()
                .mapToInt(PlayerName::getLength)
                .max()
                .orElse(0);
    }

    public int getPlayerCount() {
        return names.size();
    }

    public List<String> getNames() {
        return names.stream()
                .map(PlayerName::getValue)
                .toList();
    }
}
