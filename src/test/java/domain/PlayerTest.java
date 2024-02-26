package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    @DisplayName("주어진 방향으로 위치를 이동시킨다")
    void testMovePosition() {
        int testPosition = 1;
        String testName= "pobi";
        Name name = new Name(testName);
        Player player = new Player(name, testPosition);
        Direction direction = Direction.LEFT;
        player.move(direction);

        Assertions.assertEquals(0, player.getPosition());

    }
}
