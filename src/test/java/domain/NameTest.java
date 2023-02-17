package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @DisplayName("사람의 이름은 1글자 이상 5글자 이하이다.")
    @ParameterizedTest
    @ValueSource(strings = {"깃", "깃짱", "제리제리", "제리제리제"})
    void validaNameTest(String name) {
        assertDoesNotThrow(() -> new Name(name));
    }

    @DisplayName("사람의 이름이 5글자 초과인 경우 예외처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"깃짱깃짱깃짱", "제리제리제리"})
    void invalidNameLengthTest(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(name));
    }

    @DisplayName("사람의 이름이 빈 문자열(공백)이거나 1글자 미만인 경우 예외처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void invalidBlankNameTest(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(name));
    }
}
