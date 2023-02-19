package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름의 길이가 1~5인 경우, 예외가 발생하지 않는다.")
    void validateNameLength_Success() {
        assertThatNoException().isThrownBy(() -> new Name("encho"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"gray12", ""})
    @DisplayName("이름의 길이가 1~5가 아닌 경우, 예외가 발생한다.")
    void validateNameLength_Fail(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" gray", "ann ", "po bi", " "})
    @DisplayName("이름에 공백이 있는 경우 예외가 발생한다.")
    void validateNameWithSpace_Fail(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NAME_FORMAT_ERROR.getMessage());
    }

}
