package domain.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.ladder.DirectionalRung;
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
}
