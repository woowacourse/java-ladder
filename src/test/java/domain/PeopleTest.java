package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PeopleTest {
    @DisplayName("이름으로 People객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "aa", "aaa", "aaaa", "aaaaa"})
    void 이름_길이_People_객체_생성_태스트(String name){
        Assertions.assertDoesNotThrow(()->{
            new People(name);
        });
    }
}
