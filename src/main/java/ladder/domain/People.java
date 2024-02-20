package ladder.domain;

import java.util.List;

public class People {

    List<Person> people;

    public People(List<Person> people) {
        validate(people);
        this.people = people;
    }

    private void validate(List<Person> people) {
        if (people.size() != people.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }
}
