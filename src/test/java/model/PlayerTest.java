package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    @DisplayName("정상적인 플레이어 이름 입력시 플레이어 객체를 생성한다.")
    void createPlayer() {
        String name = "pobi";
        Assertions.assertThatCode(() -> new Player(name))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("플레이어의 이름이 5자 초과여서 오류가 발생한다.")
    void invalidNameLength() {
        String name = "pobipobi";
        Assertions.assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
