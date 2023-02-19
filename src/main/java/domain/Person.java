package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class Person {

    private final List<People> person;

    public Person(List<People> person) {
        this.person = person;
    }

    public List<People> getPerson() {
        return person;
    }
}
