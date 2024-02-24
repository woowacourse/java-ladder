package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        assertThatCode(() -> new Game(List.of("pobi", "atom"), List.of("꽝", "3000"), 3))
                .doesNotThrowAnyException();
    }

    @DisplayName("실행 결과는 사용자의 수와 동일하다.")
    @Test
    void checkGameResultSize() {
        assertThatThrownBy(() -> new Game(List.of("pobi", "atom"), List.of("3000"), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
