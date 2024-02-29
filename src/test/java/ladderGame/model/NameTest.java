package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름은 6글자 이상일 시 예외처리 된다.")
    void validateNameLength() {
        assertThatThrownBy(() -> new Name("켬미켬미켬미"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("이름은 공백일 시 예외처리 된다.")
    void validateNotBlank(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
