package domain;

import java.util.List;

public class Names {
    private final List<Name> names;

    Names(List<String> names) {
        validateDuplicateName(names);
        this.names = names.stream().map(Name::new).toList();
    }

    private void validateDuplicateName(List<String> splitNames) {
        long distinctCount = splitNames.stream().distinct().count();
        if (distinctCount != splitNames.size()) {
            throw new LadderGameException(ExceptionType.NAMES_DUPLICATE);
        }
    }

    List<String> getRawNames() {
        return names.stream()
                .map(Name::getName)
                .toList();
    }

    Position position(String rawName) {
        Name needToFind = new Name(rawName);
        try {
            int rawPosition = names.indexOf(needToFind);
            return Position.getCachedPosition(rawPosition, names.size() - 1);
        } catch (NullPointerException e) {
            throw new LadderGameException(ExceptionType.NAME_NOT_FOUND);
        }
    }

    int getNameCount() {
        return names.size();
    }
}
