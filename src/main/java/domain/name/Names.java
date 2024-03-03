package domain.name;

import domain.exception.ExceptionType;
import domain.exception.LadderGameException;
import java.util.List;

public class Names {
    private static final int MIN_NAMES_COUNT = 2;
    private static final int MAX_NAMES_COUNT = 10;
    private final List<Name> names;

    public Names(List<Name> names) {
        validateDuplicateName(names);
        validateNameCount(names);
        this.names = names;
    }

    public int count() {
        return names.size();
    }

    public List<Name> getNames() {
        return names;
    }
    
    private void validateNameCount(List<Name> names) {
        if (names.size() < MIN_NAMES_COUNT || names.size() > MAX_NAMES_COUNT) {
            throw new LadderGameException(ExceptionType.INVALID_NAMES_RANGE);
        }
    }

    private void validateDuplicateName(List<Name> name) {
        long distinctCount = name.stream().distinct().count();
        if (distinctCount != name.size()) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_DUPLICATE_NAME);
        }
    }
}
