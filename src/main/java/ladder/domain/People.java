package ladder.domain;

import ladder.view.enums.Command;

import java.util.Collections;
import java.util.List;

public class People {
    private static final String NAME_RULE = "[a-zA-Z0-9]{1,5}";
    private static final int MIN_PEOPLE_NUMBERS = 1;
    private static final int MAX_PEOPLE_NUMBERS = 100;
    private final List<String> names;

    public People(List<String> names) {
        validatePeopleNumber(names);

        for (String name : names) {
            validateNameRule(name);
            validateNotCommand(name);
        }
        this.names = Collections.unmodifiableList(names);
    }

    public List<String> getNames() {
        return names;
    }

    private void validatePeopleNumber(List<String> names) {
        if (names.size() < MIN_PEOPLE_NUMBERS || names.size() > MAX_PEOPLE_NUMBERS) {
            throw new IllegalArgumentException("참여자 수는 1이상 100이하만 가능합니다.");
        }
    }

    private void validateNameRule(String name) {
        if (name == null || !name.matches(NAME_RULE)) {
            throw new IllegalArgumentException("이름은 5자 이내의 영숫자로 구성되어야 합니다.");
        }
    }

    private void validateNotCommand(String name) {
        if (Command.contains(name)) {
            throw new IllegalArgumentException("명령어를 이름으로 할 수 없습니다: "+ name);
        }
    }
}
