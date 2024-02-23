package ladder.domain;

import java.util.Collections;
import java.util.List;

public class People {

    private static final int MIN_PEOPLE_NUMBERS = 1;
    private static final int MAX_PEOPLE_NUMBERS = 100;
    private final List<Name> names;

    public People(List<String> names) {
        validatePeopleNumber(names);

        this.names = names.stream()
                .map(Name::new)
                .toList();
    }

    private void validatePeopleNumber(List<String> names) {
        if (names.size() < MIN_PEOPLE_NUMBERS || names.size() > MAX_PEOPLE_NUMBERS) {
            throw new IllegalArgumentException("참여자 수는 1이상 100이하만 가능합니다.");
        }
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
