package ladder.domain.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("Name 객체 equals 테스트")
    void equalsTest() {
        String nameValue = "pobi";
        Name name = new Name(nameValue);
        Name other = new Name(nameValue);
        assertThat(name).isEqualTo(other);
    }

    @DisplayName("이름 생성할 때")
    @Nested
    class NameInitiatorTest {
        @DisplayName("길이는  1 이상 5 이하일 떄 정상 작동한다. 영어, 숫자, 공백 = 길이 1 / 한글 = 길이 2")
        @ParameterizedTest(name = "inputName = {0}")
        @ValueSource(strings = {"가", "가나", "a", "aaaaa"})
        void createNameTest(String name) {
            Assertions.assertDoesNotThrow(() -> new Name(name));
        }

        @DisplayName("공백, 빈문자열이거나 길이가 5 초과 떄 예외가 발생한다. 영어, 숫자, 공백 = 길이 1 / 한글 = 길이 2")
        @ParameterizedTest(name = "inputName = {0}")
        @ValueSource(strings = {"", "    ", "가나다", "aaaaaa"})
        void createNameExceptionTest(String name) {
            assertThatThrownBy(() -> new Name(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("플레이어의 이름 길이는 1 이상 5 이하여야 합니다. 영어, 숫자, 공백 = 길이 1 / 한글 = 길이 2");
        }
    }

}
