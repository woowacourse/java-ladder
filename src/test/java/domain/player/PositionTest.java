package domain.player;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("위치를 증가시켜도 기존 객체의 값은 변하지 않는다.")
    @Test
    void doesNotChangedByIncrease() {
        //given
        final Position position = new Position();

        //when
        position.increase();

        //then
        assertThat(position).isEqualTo(new Position());
    }

    @DisplayName("위치를 증가시키면 값이 1 증가된 새로운 객체가 생성된다.")
    @Test
    void getNewInstanceByIncrease() {
        //given
        final Position position = new Position();

        //when
        final Position increasedPosition = position.increase();

        //then
        assertThat(increasedPosition).isEqualTo(new Position(1));
    }

    @DisplayName("위치를 감소시켜도 기존 객체의 값은 변하지 않는다.")
    @Test
    void doesNotChangedBydecrease() {
        //given
        final Position position = new Position();

        //when
        position.decrease();

        //then
        assertThat(position).isEqualTo(new Position());
    }

    @DisplayName("위치를 감소시키면 값이 1 감소된 새로운 객체가 생성된다.")
    @Test
    void getNewInstanceBydecrease() {
        //given
        final Position position = new Position();

        //when
        final Position decreasedPosition = position.decrease();

        //then
        assertThat(decreasedPosition).isEqualTo(new Position(-1));
    }
}
