package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.player.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("디딤대는 ")
class StepTest {

    private Position position;

    @BeforeEach
    void setUp() {
        //given
        position = new Position(1);
    }

    @Test
    @DisplayName(" 오른쪽 발판일 때 사용자 위치를 오른쪽으로 보낸다.")
    void whenConnectedToRight_thenMoveRight() {
        //when
        Step.RIGHT.step(position);

        //then
        assertThat(position)
                .extracting("position")
                .isEqualTo(2);
    }

    @Test
    @DisplayName(" 왼쪽 발판일 때 사용자 위치를 오른쪽으로 보낸다.")
    void whenConnectedToLeft_thenMoveLeft() {
        //when
        Step.LEFT.step(position);

        //then
        assertThat(position)
                .extracting("position")
                .isEqualTo(0);
    }

    @Test
    @DisplayName(" 없을 때 아래로 보내기 때문에 값이 변하지 않는다.")
    void givenCurrentPosition_thenGiveNextLinePosition() {
        //when
        Step.NONE.step(position);

        //then
        assertThat(position)
                .extracting("position")
                .isEqualTo(1);
    }
}
