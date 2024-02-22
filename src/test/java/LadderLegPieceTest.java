import domain.ladder.common.Direction;
import domain.ladder.LadderLegPiece;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;
public class LadderLegPieceTest {
    @Test
    @DisplayName("방향을 통해 사다리조각을 생성한다.")
    public void createLadderPiece(){
        Direction direction = Direction.DOWN;

        LadderLegPiece ladderLegPiece = new LadderLegPiece(direction);

        assertEquals(ladderLegPiece.getDirection(),direction);
    }

    @DisplayName("사다리조각의 방향이 오른쪽 여부에 따라서 Boolean 값을 반환한다.")
    @ParameterizedTest
    @EnumSource(Direction.class)
    public void testIsRightDirection(Direction value) {
        LadderLegPiece ladderLegPiece = new LadderLegPiece(value);
        assertEquals(value.equals(Direction.RIGHT), ladderLegPiece.isRightDirection());
    }
}
