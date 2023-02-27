package domain;

import domain.LadderGameTest.TestFlapValueBooleanGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PersonTest {
    @DisplayName("이름으로 Person 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "aa", "aaa", "aaaa", "aaaaa"})
    void 이름_길이_Person_객체_생성_테스트(String name) {
        Assertions.assertDoesNotThrow(() -> {
            new Person(name, 0);
        });
    }

    @DisplayName("이름으로 Person 객체 생성 실패 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "aaaaaa"})
    void 이름_길이_Person_객체_생성_실패_테스트(String name) {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Person(name, 0);
        });
    }

    @DisplayName("Person 객체 위치 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:1", "10:15:5"}, delimiter = ':')
    void Person_객체_위치_이동_테스트(final int left, final int right, final int expected) {
        Person person = new Person("p", 0);

        for (int i = 0; i < left; i++) {
            person.goLeft();
        }
        for (int i = 0; i < right; i++) {
            person.goRight();
        }

        Assertions.assertEquals(person.getPosition(), expected);
    }

    @DisplayName("Person 객체 위치 이동 테스트")
    @Test
    void Line을_주고_Person_객체_위치_이동_테스트() {
        Line line = Line.newInstanceWithPersonCount(2, new TestFlapValueBooleanGenerator());
        Person person1 = new Person("p1", 0);
        Person person2 = new Person("p2", 1);

        person1.move(line, 2);

        Assertions.assertEquals(1, person1.getPosition());
    }
}
