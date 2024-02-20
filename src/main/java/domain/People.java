package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class People {
    private static final String DELIMITER = ",";
    private static final int MIN_COUNT = 2;

    private final List<Person> values;

    private People(List<Person> values) {
        this.values = new ArrayList<>(values);
        validateCount(this.values);
    }

    private static void validateCount(List<Person> values) {
        if (values.size() < MIN_COUNT) {
            throw new IllegalArgumentException("[ERROR] 사다리 게임에 참여하는 사람의 수는 2명 이상 이여야 합니다.");
        }
    }

    public static People from(String names) {
        return new People(Arrays.stream(names.split(DELIMITER))
                .map(Person::new)
                .toList());
    }
}
