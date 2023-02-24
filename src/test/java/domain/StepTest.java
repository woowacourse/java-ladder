package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("디딤대는 ")
class StepTest {
    @Test
    @DisplayName(" 오른쪽 발판일 때 사용자 위치를 오른쪽으로 보낸다.")
    void whenConnectedToRight_thenMoveRight() {
        assertThat(Step.RIGHT.move(2))
                .isEqualTo(3);
    }

    @Test
    @DisplayName(" 왼쪽 발판일 때 사용자 위치를 오른쪽으로 보낸다.")
    void whenConnectedToLeft_thenMoveLeft() {
        assertThat(Step.LEFT.move(2))
                .isEqualTo(1);
    }

    @Test
    @DisplayName(" 없을 때 아래로 보내기 때문에 값이 변하지 않는다.")
    void givenCurrentPosition_thenGiveNextLinePosition() {
        assertThat(Step.NONE.move(2))
                .isEqualTo(2);
    }
}
