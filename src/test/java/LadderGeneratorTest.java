import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGeneratorTest {

    @Test
    @DisplayName("Ladder의 높이와 Player 수를 통해 Ladder 생성기를 생성한다.")
    public void createLadderGenerator(){
        Height height = new Height("5");
        Integer playerCount = 5;

        LadderGenerator ladder = new LadderGenerator(height, playerCount);

        assertInstanceOf(LadderGenerator.class, ladder);
    }
    @Test
    @DisplayName("가지가 없는 빈 LadderLeg 를 생성한다.")
    public void generateLadderLeg(){
        Height height = new Height("5");
        Integer playerCount = 5;
        LadderGenerator ladder = new LadderGenerator(height, playerCount);

        LadderLeg ladderLeg = ladder.generateDownLadderLeg();

        for(int i =0 ;i<height.getHeight();i++){
            assertEquals(ladderLeg.getDirectionAtIndex(i),Direction.DOWN);
        }
    }
}