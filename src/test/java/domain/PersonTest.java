package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
}
