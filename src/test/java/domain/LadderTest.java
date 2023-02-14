package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @ParameterizedTest
    @DisplayName("양의 정수 외의 값이 들어오면 예외가 발생한다.")
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0})
    void create_NotPositive(int input) {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(input);
        }).withMessage("[ERROR] 사다리의 높이는 양의 정수여야 합니다.");
    }

}
