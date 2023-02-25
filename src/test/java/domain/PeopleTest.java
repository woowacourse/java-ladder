package domain;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PeopleTest {
    @DisplayName("People에서 이름으로 특정 Person 탐색 테스트")
    @Test
    void People에서_이름으로_Person_탐색_테스트() {
        Person person1 = new Person("aa", 0);
        Person person2 = new Person("bb", 1);
        People people = new People(Arrays.asList(person1, person2));
        Assertions.assertEquals(person1.getName().getPersonName(), people.findPerson(person1.getName().getPersonName()).getName().getPersonName());
    }

    @DisplayName("People에서 중복된 이름인 경우 특정 Person 탐색 실패 테스트")
    @Test
    void People에서_중복이름으로_Person_탐색_실패_테스트() {
        Person person1 = new Person("aa", 0);
        Person person2 = new Person("aa", 1);
        People people = new People(Arrays.asList(person1, person2));
        Assertions.assertThrows(IllegalStateException.class, () -> {
            people.findPerson(person1.getName().getPersonName());
        });
    }

    @DisplayName("People에서 없는 이름인 경우 특정 Person 탐색 실패 테스트")
    @Test
    void People에서_없는_이름으로_Person_탐색_실패_테스트() {
        Person person1 = new Person("aa", 0);
        Person person2 = new Person("bb", 1);
        People people = new People(Arrays.asList(person1, person2));
        Assertions.assertThrows(IllegalStateException.class, () -> {
            people.findPerson("none");
        });
    }
}
