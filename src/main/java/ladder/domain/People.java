package ladder.domain;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toUnmodifiableList;

public class People {
    private static final int PEOPLE_SIZE_LOWER_BOUND_INCLUSIVE = 2;
    private final List<Person> people;

    private People(List<Person> people) {
        validateSize(people);
        this.people = people;
    }

    public static People from(List<String> names) {
        return names.stream().map(Person::new).collect(collectingAndThen(toUnmodifiableList(), People::new));
    }

    private void validateSize(List<Person> people){
        if(people.size() < PEOPLE_SIZE_LOWER_BOUND_INCLUSIVE){
            throw new IllegalArgumentException("");
        }
    }

    public int getPeopleSize() {
        return people.size();
    }


    public List<String> getNames() {
        return people.stream().map(person -> person.getName()).collect(toUnmodifiableList());
    }
}
