package domain.db;

import java.util.Arrays;
import java.util.List;

public record Names(List<Name> names) {
    public Names(String[] names) {
        this(Arrays.stream(names).map(Name::new).toList());
        validateDuplicateNames();
    }

    public int getSequence(final String name) {
        return names.indexOf(new Name(name));
    }

    private void validateDuplicateNames() {
        if (this.names.size() != getUniqueNameCount()) {
            throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다");
        }
    }

    private long getUniqueNameCount() {
        return this.names.stream().distinct().count();
    }
}
