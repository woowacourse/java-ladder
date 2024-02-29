package ladder.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class People {
    private static final int MIN_COUNT = 2;
    private static final String MIN_PEOPLE_COUNT = "사다리 게임에 참여하는 사람의 수는 2명 이상 이여야 합니다.";
    private static final String NAMES_NOT_DUPLICATED = "이름은 중복될 수 없습니다.";

    private final List<Person> values;

    private People(List<Person> values) {
        this.values = new ArrayList<>(values);
        validateCount(this.values);
        validateDuplicated(this.values);
    }

    public static People from(List<String> names) {
        return new People(names.stream()
                .map(Person::new)
                .toList());
    }

    private void validateCount(List<Person> values) {
        if (values.size() < MIN_COUNT) {
            throw new IllegalArgumentException(MIN_PEOPLE_COUNT);
        }
    }

    private void validateDuplicated(List<Person> values) {
        if (values.size() != getUniqueNamesSize()) {
            throw new IllegalArgumentException(NAMES_NOT_DUPLICATED);
        }
    }

    private int getUniqueNamesSize() {
        return new HashSet<>(getNames()).size();
    }

    public int getCount() {
        return values.size();
    }

    public String getName(int index) {
        return values.get(index).getName();
    }

    public List<String> getNames() {
        return values.stream()
                .map(Person::getName)
                .toList();
    }
}
