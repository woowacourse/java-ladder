package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameResultTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        assertThatCode(() -> new GameResult("a"))
                .doesNotThrowAnyException();
    }

    @DisplayName("실행 결과는 양 옆 공백을 제외한 1글자 이상이다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "\n\r", "\r"})
    void checkGameResultNameLength(String source) {
        assertThatThrownBy(() -> new GameResult(source))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
