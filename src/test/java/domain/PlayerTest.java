package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 22.
 */
public class PlayerTest {

    @DisplayName("사다리를 탈 수 있는지에 대한 여부가 L이면 position 감소, R이면 position 증가")
    @Test
    void updatePosition() {
        // given
        Player player = new Player("베베", 3);

        // when
        player.calculatePosition("L");
        player.calculatePosition("R");
        player.calculatePosition("R");

        // then
        Assertions.assertEquals(player.getPosition(), 4);
    }

}
