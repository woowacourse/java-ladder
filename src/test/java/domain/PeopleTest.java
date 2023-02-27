package domain;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PeopleTest {
    private Person person1;
    private Person person2;
    private People people;

    @BeforeEach
    void init() {
        person1 = new Person("aa", 0);
        person2 = new Person("bb", 1);
        people = new People(Arrays.asList(person1, person2));
    }

    @DisplayName("People에서 이름으로 특정 Person 탐색 테스트")
    @Test
    void People에서_이름으로_Person_탐색_테스트() {

        Assertions.assertEquals(person1.getName().getPersonName()
                , people.findPerson(person1.getName().getPersonName()).getName().getPersonName());
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
        Assertions.assertThrows(IllegalStateException.class, () -> {
            people.findPerson("none");
        });
    }

    @DisplayName("People에 Person을 한 명만 추가하는 경우 생성 실패 테스트")
    @Test
    void Person_한명으로_생성_실패_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new People(Arrays.asList(person1));
        });
    }

    @DisplayName("People 내부 최대 이름 길이 계산 테스트")
    @Test
    void People_내부_최대_이름_길이_계산_테스트() {
        Person longestPerson = new Person("ccccc", 2);
        People people = new People(Arrays.asList(person1, person2, longestPerson));
        Assertions.assertEquals(longestPerson.getName().getPersonName().length(), people.calculateMaxNameLength());
    }
}
