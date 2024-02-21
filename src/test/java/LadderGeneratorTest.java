import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderGeneratorTest {

    @Test
    @DisplayName("Ladder의 높이와 Player 수를 통해 Ladder 생성기를 생성한다.")
    public void createLadderGenerator() {
        Height height = new Height("5");
        Integer playerCount = 5;

        LadderGenerator ladder = new LadderGenerator(height, playerCount);

        assertInstanceOf(LadderGenerator.class, ladder);
    }

    @Test
    @DisplayName("가지가 없는 빈 LadderLeg 를 생성한다.")
    public void generateDownLadderLeg() {
        Height height = new Height("5");
        Integer playerCount = 5;
        LadderGenerator ladder = new LadderGenerator(height, playerCount);

        LadderLeg ladderLeg = ladder.generateDownLadderLeg();

        for (int i = 0; i < height.getHeight(); i++) {
            assertEquals(ladderLeg.getDirectionAtIndex(i), Direction.DOWN);
        }
    }

    @Test
    @DisplayName("전 LadderLeg 와 DirectionGenerator 를 통해 가지를 가지는 LadderLeg 를 생성한다.")
    public void generateLadderLeg() {
        LadderGenerator ladderGenerator = 사다리_생성기_생성();
        List<Direction> fixedDirectionList = List
                .of(Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT);

        LadderLeg downLadderLeg = ladderGenerator.generateDownLadderLeg();
        LadderLeg ladderLeg = ladderGenerator
                .generateLadderLeg(downLadderLeg,
                        new FixedDirectionGenerator(fixedDirectionList));
        for (int i = 0; i < 5; i++) {
            assertEquals(ladderLeg.getDirectionAtIndex(i), fixedDirectionList.get(i));
        }
    }

    @Test
    @DisplayName("전 LadderLeg의 동일 index가 오른쪽 가지를 가질때, 왼쪽 가지를 가지는 LadderLeg 를 생성한다.")
    public void generateLeftDirectionLadderLeg() {
        LadderGenerator ladderGenerator = 사다리_생성기_생성();
        List<Direction> fixedDirectionList = List
                .of(Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT);

        LadderLeg rightLadderLeg =
                ladderGenerator.generateLadderLeg(
                        ladderGenerator.generateDownLadderLeg(),
                        new FixedDirectionGenerator(fixedDirectionList));

        LadderLeg testLeftLadderLeg =
                ladderGenerator.generateLadderLeg(
                        rightLadderLeg,
                        new FixedDirectionGenerator(fixedDirectionList));

        for (int i = 0; i < 5; i++) {
            assertEquals(testLeftLadderLeg.getDirectionAtIndex(i),Direction.LEFT);
        }
    }

    private LadderGenerator 사다리_생성기_생성() {
        Height height = new Height("5");
        Integer playerCount = 5;
        return new LadderGenerator(height, playerCount);
    }

    private class FixedDirectionGenerator implements DirectionGenerator {
        List<Direction> fixedList;
        Integer index = 0;

        FixedDirectionGenerator(List<Direction> fixedList) {
            this.fixedList = fixedList;
        }

        @Override
        public Direction generate() {
            return fixedList.get(index++);
        }
    }

}