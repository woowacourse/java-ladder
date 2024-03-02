package domain;

import java.util.Collections;
import java.util.List;

public class Players{

    private final List<Name> names;

    public Players (List<String> names) {
        validateNumber(names);
        this.names = names.stream()
                .map(Name::new)
                .toList();
    }

    public int getPersonCount() {
        return names.size();
    }

    private void validateNumber(List<String> names) {
        if (names.size() < 2 || names.size() > 10){
            throw new IllegalArgumentException("이름의 수는 2이상 10이하여야 합니다.");
        }
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(this.names);
    }
}
