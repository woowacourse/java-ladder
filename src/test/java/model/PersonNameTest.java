package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PersonNameTest {

    @ParameterizedTest(name = "사람의 이름은 최소 1글자 최대 5글자다.")
    @ValueSource(strings = {"", "mollly"})
    void createPersonThrowException(String name) {
        assertThatThrownBy(() -> new Person(name))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최소 1글자 최대 5글자여야 합니다.");
    }
}
