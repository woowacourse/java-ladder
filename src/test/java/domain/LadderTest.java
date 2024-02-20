package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @DisplayName("사다리 높이가 자연수가 아닐 경우 예외 처리 테스트")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"abc", "-1", "0", "", " "})
    void validateHeightTest(String height) {
        assertThatThrownBy(() -> new Ladder(height))
                .isInstanceOf(IllegalArgumentException.class);
    }
}