package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("이름이 최대 글자를 초과할 경우 예외가 발생한다.")
    @Test
    void occurExceptionIfNameExceedsMaxLength() {
        assertThatThrownBy(() -> new Player("clover"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }
}
