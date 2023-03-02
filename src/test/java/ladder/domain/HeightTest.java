package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @ParameterizedTest
    @DisplayName("1보다 낮은 값이 들어오거나 26보다 큰 값이 들어오면 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 27})
    void create_UnderThan1OrOverThan26(int input) {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Height(input, 2);
        }).withMessage("[ERROR] 사다리의 높이는 1~26 사이여야 합니다.");
    }

    @Test
    @DisplayName("Height 클래스가 정상적으로 생성되어야 한다.")
    void create_success() {
        // expect
        assertThatNoException().isThrownBy(() -> {
            new Height(10, 10);
        });
    }

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수보다 작으면 예외가 발생한다.")
    void create_heightMinPlayersCount() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Height(3, 4);
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수의 2배보다 크면 예외가 발생한다.")
    void create_heightMaxPlayersCount() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Height(7, 3);
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }
}
