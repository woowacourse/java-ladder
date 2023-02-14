package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @ParameterizedTest
    @DisplayName("양의 정수 외의 값이 들어오면 예외가 발생한다.")
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0})
    void create_NotPositive(int input) {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(input, 5);
        }).withMessage("[ERROR] 사다리의 높이는 양의 정수여야 합니다.");
    }

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수보다 작으면 예외가 발생한다.")
    void create_heightMinPlayersCount() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(1, 2);
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수의 2배보다 크면 예외가 발생한다.")
    void create_heightMaxPlayersCount() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(5, 2);
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }
}
