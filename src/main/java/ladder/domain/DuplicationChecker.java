package ladder.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicationChecker {
    public static <T> boolean hasDuplication(List<T> names) {
        Set<T> set = new HashSet<>(names);
        return set.size() != names.size();
    }
}
