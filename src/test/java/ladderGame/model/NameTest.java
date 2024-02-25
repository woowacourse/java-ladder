package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름은 6글자 이상일 시 예외처리 된다.")
    void validateNameLength() {
        assertThatThrownBy(() -> new Name("켬미켬미켬미"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5글자까지 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "초롱", "ab cd"})
    @DisplayName("이름에 영문과 숫자 외에 입력이 들어가는 경우 예외처리 된다.")
    void validateNotBlank(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 영문과 숫자로만 입력해야 합니다.");
    }
}
