package domain.player;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("정상 입력을 통해 이름을 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"깃짱", "제리"})
    void validaNameTest(String name) {
        assertDoesNotThrow(() -> new Name(name));
    }

    @DisplayName("비정상 입력으로는 이름을 생성할 수 없다.")
    @Nested
    class invalidNameTest {
        @DisplayName("5글자를 초과하는 이름은 생성할 수 없다.")
        @ParameterizedTest
        @ValueSource(strings = {"깃짱깃짱깃짱", "제리제리제리"})
        void invalidNameLengthTest(String name) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Name(name));
        }

        @DisplayName("all이라는 이름은 생성할 수 없다.")
        @Test
        void allNameTest() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Name("all"));
        }

        @DisplayName("공백으로는 이름을 생성할 수 없다.")
        @ParameterizedTest
        @ValueSource(strings = {"", " "})
        void invalidBlankNameTest(String name) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Name(name));
        }
    }
}
