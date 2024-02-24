package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @DisplayName("생성 테스트")
    @Test
    void createTest() {
        assertThatCode(() -> new Player("산초"))
                .doesNotThrowAnyException();
    }

    @DisplayName("사용자의 이름은 양 옆 공백을 제외한 1자 이상이다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "\r\n", "\r"})
    void checkPlayerNameLengthMin(String source) {
        assertThatThrownBy(() -> new Player(source))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 이름은 양 옆 공백을 제외한 5자 이하이다.")
    @Test
    void checkPlayerNameLengthMax() {
        assertThatThrownBy(() -> new Player("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
