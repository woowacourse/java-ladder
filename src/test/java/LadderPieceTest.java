import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class LadderPieceTest {
    @Test
    @DisplayName("방향을 통해 사다리조각을 생성한다.")
    public void createLadderPiece(){
        Direction direction = Direction.DOWN;

        LadderPiece ladderPiece = new LadderPiece(direction);

        assertEquals(ladderPiece.getDirection(),direction);
    }
}
