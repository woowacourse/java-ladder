package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @Test
    @DisplayName("정상적인 플레이어 이름 입력시 플레이어 객체를 생성한다.")
    void createPlayer() {
        String name = "pobi";
        Assertions.assertThatCode(() -> new Player(name))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("플레이어의 이름이 5자 초과여서 예외가 발생한다.")
    void invalidNameLength() {
        String name = "browny";
        Assertions.assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("영문자가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"레디", "123", "!@", "😀"})
    void invalidNameSpec(String name) {
        Assertions.assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
