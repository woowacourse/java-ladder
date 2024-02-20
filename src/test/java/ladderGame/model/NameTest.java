package ladderGame.model;

import ladderGame.model.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("문자열을 인자로 넘겨서 Name 객체를 생성할 수 있다.")
    void createName() {
        assertThatCode(() -> new Name("이름"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "aaaaaa"})
    @DisplayName("이름은 6글자 이상일 시 예외처리 된다.")
    void validateNameLength(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5글자까지 가능합니다.");
    }
}