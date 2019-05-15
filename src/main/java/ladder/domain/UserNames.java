package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserNames {
    private final List<String> names;

    UserNames(final String names) {
        this.names = splitNames(names);
    }

    List<String> splitNames(String names) {
        return Arrays.asList(names.split(","));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserNames userNames = (UserNames) o;
        return Objects.equals(names, userNames.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
