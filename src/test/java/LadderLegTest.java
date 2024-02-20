import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LadderLegTest {
    @Test
    @DisplayName("사다리 조각을 통해 사다리 다리를 만든다.")
    public void createLadderLeg() {
        List<Direction> directions = List.of(Direction.LEFT, Direction.RIGHT);
        List<LadderPiece> ladderPieces = 사다리_조각들_생성(directions);

        LadderLeg ladderLeg = new LadderLeg(ladderPieces);

        assertInstanceOf(LadderLeg.class, ladderLeg);
    }

    @Test
    @DisplayName("가지고 있는 특정 사다리 조각의 방향이 오른쪽인지 확인한다.")
    public void checkLadderPieceDirection() {
        List<Direction> directions = List.of(Direction.RIGHT, Direction.LEFT);
        List<LadderPiece> ladderPieces = 사다리_조각들_생성(directions);

        LadderLeg ladderLeg = new LadderLeg(ladderPieces);

        assertTrue(ladderLeg.hasRightDirectionAtIndex(0));
        assertFalse(ladderLeg.hasRightDirectionAtIndex(1));
    }

    private List<LadderPiece> 사다리_조각들_생성(List<Direction> directions) {
        return directions.stream()
                         .map(LadderPiece::new)
                         .toList();
    }
}
