package domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class People implements Iterable<Person> {

    public static final int MIN_PERSON_COUNT = 2;

    private final List<Person> people;

    public People(List<String> names) {
        validateDuplicate(names);
        List<Person> people = toList(names);
        validatePersonCount(people);
        this.people = people;
    }

    private void validateDuplicate(List<String> result) {
        if (result.size() != result.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    private List<Person> toList(List<String> names) {
        return names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    private void validatePersonCount(List<Person> people) {
        if (people.size() < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException(
                    String.format("사람은 %d명 이상이어야 합니다.", MIN_PERSON_COUNT));
        }
    }

    public Person getByIndex(int index) {
        if (index < 0 || index >= people.size()) {
            throw new IndexOutOfBoundsException("인덱스의 범위를 벗어났습니다.");
        }
        return people.get(index);
    }

    public int findPersonColumn(Person person) {
        return IntStream.range(0, people.size())
                .filter(index -> people.get(index).equals(person))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자는 존재하지 않습니다."));

    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public int getCount() {
        return people.size();
    }

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }
}
