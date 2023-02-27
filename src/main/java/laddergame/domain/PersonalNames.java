package laddergame.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonalNames {
    private final List<PersonalName> personalNames;

    public PersonalNames(final List<String> personalNames) {
        validate(personalNames);
        this.personalNames = personalNames.stream().map(PersonalName::valueOf).collect(Collectors.toUnmodifiableList());
    }

    private void validate(List<String> personalNames) {
        if (personalNames.isEmpty() || personalNames.size() == 1) {
            throw new IllegalArgumentException("이름은 2개 이상이어야 합니다.");
        }
        Set<String> distinctNames = new HashSet<>(personalNames);
        if (personalNames.size() != distinctNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 존재할 수 없습니다.");
        }
    }

    public int getSize() {
        return personalNames.size();
    }

    public List<PersonalName> getPersonalNames() {
        return personalNames;
    }
}
