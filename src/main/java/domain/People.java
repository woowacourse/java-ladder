package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class People {

    private final List<Person> people;

    public People(List<Person> people) {
        validatePeopleNumber(people);
        this.people = people;
    }

    private static void validatePeopleNumber(List<Person> people) {
        if (people.size() <= 1) {
            throw new IllegalArgumentException("진행자 수는 2명 이상이어야 합니다.");
        }
    }

    public List<Person> getPeople() {
        return new ArrayList<>(people);
    }

    public int calculateMaxNameLength() {
        return people.stream().mapToInt(p -> p.getName().getPersonName().length()).max().orElseThrow();
    }

    public Person findPerson(String name) {
        List<Person> findPeople = people.stream().filter(p -> p.getName().getPersonName().equals(name))
                .collect(Collectors.toList());
        if (findPeople.size() >= 2) {
            throw new IllegalStateException("중복된 참여자가 검색되었습니다.");
        }
        if (findPeople.size() == 0) {
            throw new IllegalStateException("참여자 검색을 실패했습니다.");
        }
        return findPeople.get(0);
    }
}
