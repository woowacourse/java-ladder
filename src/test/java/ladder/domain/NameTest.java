package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @DisplayName("플레이어 이름 생성할 때")
    @Nested
    class PlayerInitiatorTest {
        @DisplayName("1자 이상 5자 이하 일 떄 정상 작동한다.")
        @ParameterizedTest(name = "inputName = {0}")
        @ValueSource(strings = {"가", "가나", "가나다라마"})
        void createPlayerNameTest(String name) {
            Assertions.assertDoesNotThrow(() -> new Name(name));
        }

        @DisplayName("공백, 빈문자열이거나 5자 초과 떄 예외가 발생한다.")
        @ParameterizedTest(name = "inputName = {0}")
        @ValueSource(strings = {"", "    " , "가나다라마바", "가나다라마바사아자차"})
        void createPlayerNameExceptionTest(String name) {
            assertThatThrownBy(()-> new Name(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("플레이어의 이름은 1자 이상 5자 이하여야 합니다.");
        }

    }
}
