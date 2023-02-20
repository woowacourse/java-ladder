package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NamesTest {
    @DisplayName("이름의 수는 2명 이상 100명 이하이다.")
    @ParameterizedTest
    @ValueSource(strings = {"깃짱,제리,이리내,제나", "깃짱,제리"})
    void validNamesTest(String names) {
        Assertions.assertDoesNotThrow(() -> new Names(names));
    }

    @DisplayName("2명 미만 100명 초과의 이름 수는 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"깃짱", "제리"})
    void invalidNamesTest(String names) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names(names));
    }
}