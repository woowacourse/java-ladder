package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    @DisplayName("Position이 입력되면 Player의 위치가 변화한다.")
    void givenPosition_thenMove() {
        //given
        final int prevOrder = 0;
        final Name name = new Name("준팍");
        final Position prevPosition = Position.of(prevOrder, 3);
        final Player player = new Player(name, prevPosition);

        //when
        final int nextOrder = 1;
        final Position nextPosition = Position.of(nextOrder, 3);
        player.move(nextPosition);

        //then
        final int playerOrder = player.getOrder();
        assertThat(playerOrder).isEqualTo(nextOrder);
    }

}
