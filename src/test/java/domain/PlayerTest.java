package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"123456", ""})
    @DisplayName("참가자 이름 길이 검증")
    void validatePlayerNameLength(String name) {
        Assertions.assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름은 1글자 이상 5글자 이하여야 합니다.");
    }

}
