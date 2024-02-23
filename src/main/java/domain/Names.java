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

    List<Name> getNames() {
        return names;
    }

    int getNameCount() {
        return names.size();
    }
}
