package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PersonTest {
    @DisplayName("이름으로 Person 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "aa", "aaa", "aaaa", "aaaaa"})
    void 이름_길이_Person_객체_생성_태스트(String name){
        Assertions.assertDoesNotThrow(()->{
            new Person(name);
        });
    }

    @DisplayName("이름으로 Person 객체 생성 실패 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "aaaaaa"})
    void 이름_길이_Person_객체_생성_실패_태스트(String name){
        Assertions.assertThrowsExactly(IllegalArgumentException.class, ()->{
            new Person(name);
        });
    }

    @DisplayName("Person 객체 위치 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:1", "10:15:5"}, delimiter = ':')
    void Person_객체_위치_이동_태스트(final int left, final int right, final int expected){
        Person person = new Person("p");

        for (int i = 0; i < left; i++) {
            person.goLeft();
        }
        for (int i = 0; i < right; i++) {
            person.goRight();
        }

        Assertions.assertEquals(person.getPosition(), expected);
    }
}
