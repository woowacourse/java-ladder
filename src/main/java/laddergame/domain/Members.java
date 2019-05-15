package laddergame.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Members {
    private List<String> names;

    public Members(List<String> names) {
        if (hasDuplicateName(names)) {
            throw new IllegalArgumentException("중복된 이름은 불가능합니다.");
        }
        this.names = names;
    }

    private boolean hasDuplicateName(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        return names.size() != nonDuplicateNames.size();
    }
}
