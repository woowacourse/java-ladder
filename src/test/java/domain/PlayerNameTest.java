package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerNameTest {

    @Nested
    @DisplayName("참가자 이름 공백 테스트")
    class PlayerNameBlankTest {

        @ParameterizedTest
        @ValueSource(strings = {"", " "})
        @DisplayName("공백만 입력되면 예외가 발생한다")
        void createPlayerNameFailByBlank(String name) {
            Assertions.assertThatThrownBy(() -> new PlayerName(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
