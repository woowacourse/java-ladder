package laddergame.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PersonalNames {
    private final List<PersonalName> personalNames;

    public PersonalNames(final List<String> personalNames) {
        validate(personalNames);
        this.personalNames = personalNames.stream().map(PersonalName::new).collect(Collectors.toUnmodifiableList());
    }

    private void validate(List<String> personalNames) {
        if (Objects.isNull(personalNames)) {
            throw new IllegalArgumentException("이름 목록은 null이 될 수 없습니다.");
        }
        if (personalNames.isEmpty() || personalNames.size() == 1) {
            throw new IllegalArgumentException("이름은 2개 이상이어야 합니다.");
        }
    }

    public int getSize() {
        return personalNames.size();
    }

    public List<String> getNames() {
        return personalNames.stream()
                .map(PersonalName::getValue)
                .collect(Collectors.toUnmodifiableList());
    }
}
