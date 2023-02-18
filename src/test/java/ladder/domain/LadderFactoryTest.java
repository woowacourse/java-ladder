package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderFactoryTest {

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수보다 작으면 예외가 발생한다.")
    void create_heightMinPlayersCount() {
        // given
        int height = 5;
        int playersCount = 6;

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderFactory(height, playersCount);
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수의 2배보다 크면 예외가 발생한다.")
    void create_heightMaxPlayersCount() {
        // given
        int height = 5;
        int playersCount = 2;

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderFactory(height, playersCount);
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }
}
