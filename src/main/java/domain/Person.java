package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class Person {

    private final List<People> person;

    public Person(List<People> person) {
        validatePeopleNumber(person);
        this.person = person;
    }

    private static void validatePeopleNumber(List<People> person){
        if(person.size() <= 1)
        throw new IllegalArgumentException("진행자 수는 2명 이상이어야 합니다.");
    }

    public List<People> getPerson() {
        return Collections.unmodifiableList(person);
    }

    public int calculateMaxNameLength(){
        return person.stream().mapToInt(p -> p.getName().length()).max().orElseThrow();
    }
}
