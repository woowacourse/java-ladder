package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ladder.constant.ErrorMessage.MIN_PEOPLE_COUNT;

public class People {
    private static final String DELIMITER = ",";
    private static final int MIN_COUNT = 2;

    private final List<Person> values;

    private People(List<Person> values) {
        this.values = new ArrayList<>(values);
        validateCount(this.values);
    }

    public static People from(String names) {
        return new People(Arrays.stream(names.split(DELIMITER))
                .map(Person::new)
                .toList());
    }

    private static void validateCount(List<Person> values) {
        if (values.size() < MIN_COUNT) {
            throw new IllegalArgumentException(MIN_PEOPLE_COUNT.generate());
        }
    }

    public int getCount() {
        return values.size();
    }

    public List<String> getNames() {
        return values.stream()
                .map(Person::getName)
                .toList();
    }
}
