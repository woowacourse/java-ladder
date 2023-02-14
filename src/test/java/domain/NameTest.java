package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {


    @ParameterizedTest
    @ValueSource(strings = {"깃짱", "제리"})
    void validaNameTest(String name) {
        assertDoesNotThrow(() -> new Name(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"깃짱깃짱깃짱", "제리제리제리"})
    void invalidNameLengthTest(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void invalidBlankNameTest(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(name));
    }

}