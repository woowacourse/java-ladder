package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("위치는 ")
public class PositionTest {

    @Test
    @DisplayName("시작 위치가 올바르지 않으면 익셉션이 발생한다.")
    void generateInvalidPlayerStartPositionCase() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("방향을 받아 현재 위치를 업데이트한다.")
    void movePositionCase() {
        //given
        Position position = new Position(0);
        int direction = 1;

        //when
        position.move(direction);

        //then
        assertThat(position.getPosition())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("갈 수 없는 위치이면 익셉션을 발생한다.")
    void moveInvalidPositionCase() {
        //given
        Position position = new Position(0);
        int direction = -1;

        //when
        //then
        assertThatThrownBy(() -> position.move(direction))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
