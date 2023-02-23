package domain;

import java.util.Collections;
import java.util.List;

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

    private static void validatePeopleNumber(List<Person> people){
        if(people.size() <= 1)
        throw new IllegalArgumentException("진행자 수는 2명 이상이어야 합니다.");
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public int calculateMaxNameLength(){
        return people.stream().mapToInt(p -> p.getName().length()).max().orElseThrow();
    }
}
