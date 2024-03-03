package laddergame.domain.gameelements;

import laddergame.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("플레이어는 위치를 좌우로 움직일 수 있다")
    @Test
    void playerMovingTest(){
        Player testPlayer1 = new Player(new Name("a"), new Position(1));
        Player testPlayer2 = new Player(new Name("b"), new Position(1));

        Position expectedPosition1 = new Position(0);
        Position expectedPosition2 = new Position(2);

        testPlayer1.moveLeft();
        testPlayer2.moveRight();

        assertEquals(testPlayer1.getPosition(), expectedPosition1);
        assertEquals(testPlayer2.getPosition(), expectedPosition2);
    }

}
