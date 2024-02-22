package domain.name;

import java.util.List;

public class Players {
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복된 이름이 존재합니다.";

    private final List<Name> names;

    public Players(final List<Name> names) {
        validateDuplicateName(names);
        this.names = names;
    }

    private void validateDuplicateName(List<Name> names) {
        if (getUniqueNameSize(names) != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private long getUniqueNameSize(final List<Name> names) {
        return names.stream()
                .distinct()
                .count();
    }

    public int findMaxNameLength() {
        return names.stream()
                .mapToInt(Name::getLength)
                .max()
                .orElse(0);
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::getValue)
                .toList();
    }

    public int getPlayerCount() {
        return names.size();
    }
}
