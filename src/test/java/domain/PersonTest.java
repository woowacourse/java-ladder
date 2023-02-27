package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PersonTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "aaaaaa"})
    @DisplayName("이름 수가 1글자 미만, 5글자 초과면 예외가 발생한다")
    void createNameWithWrongLength(String name) {
        //given
        //when
        //then
        assertThatThrownBy(() -> Person.of(name, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "aaaaa"})
    @DisplayName("이름 수가 1글자 이상, 5글자 이하면 정상 생성된다")
    void createNameWithCorrectLength(String name) {
        //given
        //when
        //then
        assertDoesNotThrow(() -> Person.of(name, 0));
    }
}
