package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @DisplayName("이름을 입력받아 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void create(String value) {
        // given & when
        Name name = new Name(value);

        // then
        assertThat(name.getName()).isEqualTo(value);
    }

    @DisplayName("이름의 길이가 5를 넘으면 예외를 발생시킨다.")
    @Test
    void validateNameLength() {
        assertThatThrownBy(() -> new Name("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름길이는 5글자를 넘을 수 없습니다.");

    }

    @DisplayName("이름에 빈문자열이나 공백을 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "", "   "})
    @NullSource
    void testNameBlank(String value) {
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에 빈값을 입력할 수 없습니다.");

    }
}
