package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @Test
    @DisplayName("사용자가 정상적으로 생성되어야 한다.")
    void create_success() {
        // given
        Player glen = new Player("glen");

        // expect
        assertThat(glen.getName())
                .isEqualTo("glen");
    }

    @ParameterizedTest
    @DisplayName("사용자의 이름에 빈 값이 들어가면 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "\n", "  "})
    void create_blankName(String input) {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player(input);
        }).withMessage("[ERROR] 이름은 공백이 될 수 없습니다.");
    }

    @Test
    @DisplayName("사용자의 이름에 null 값이 들어가면 예외가 발생한다.")
    void create_nullName() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player(null);
        }).withMessage("[ERROR] 이름에 null 값이 들어갈 수 없습니다.");
    }

    @Test
    @DisplayName("사용자의 이름이 5글자를 초과하면 예외가 발생한다.")
    void create_over5Length() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player("123456");
        }).withMessage("[ERROR] 이름이 5글자를 초과할 수 없습니다.");
    }
}
