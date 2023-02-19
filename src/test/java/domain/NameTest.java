package domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("알맞은 이름을 입력하면 정상적으로 생성된다.")
    @Test
    void create_success() {
        assertThatNoException().isThrownBy(() -> new Name("name"));
    }

    @DisplayName("이름이 null이면 예외를 반환한다.")
    @Test
    void create_fail_by_null_value() {
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 null일 수 없습니다.");
    }

    @DisplayName("이름이 공백이면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void create_fail_by_blank_name(String wrongName) {
        assertThatThrownBy(() -> new Name(wrongName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 공백이거나 비어있을 수 없습니다.");
    }

    @DisplayName("이름의 길이가 5글자를 초과하면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"lensix", "len7777"})
    void create_fail_by_too_long_length(String wrongName) {
        assertThatThrownBy(() -> new Name(wrongName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1글자 이상, 5글자 이하여야합니다.");
    }
}
