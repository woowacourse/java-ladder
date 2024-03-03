package domain;

import java.util.Collections;
import java.util.List;

public class WinningNames {

    private final List<Name> names;

    public WinningNames(List<String> names, int playersNumber) {
        validateNumber(names, playersNumber);
        this.names = names.stream()
                .map(Name::new)
                .toList();
    }

    private void validateNumber(List<String> names, int playersNumber) {
        if (names.size() != playersNumber) {
            throw new IllegalArgumentException("보상의 수는 이름의 수와 같아야 합니다.");
        }
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(this.names);
    }
}
