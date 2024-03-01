package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.ladder.DirectionalRung;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class PlayerTest {
    @ParameterizedTest
    @EnumSource(value = DirectionalRung.class)
    void 플레이어는_가로대를_만나면_움직일_수_있다(DirectionalRung directionalRung) {
        // given
        int initialPosition = 0;
        Player player = new Player(new Name("ddang"), initialPosition);

        // when
        player.move(directionalRung);

        // then
        int expected = initialPosition + directionalRung.getDirection();
        int actual = player.getPosition();

        assertEquals(expected, actual);
    }

    @Test
    void 이름이_같은_플레이어는_동등성_비교시_true를_반환한다() {
        // given
        Player player1 = new Player(new Name("name"), 0);
        Player player2 = new Player(new Name("name"), 1);

        // when & then
        assertThat(player1.equals(player2)).isTrue();
    }
}
