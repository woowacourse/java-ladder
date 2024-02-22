package domain.ladder;

import domain.ladder.common.Direction;
import domain.ladder.common.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderLegGeneratorTest {

    @Test
    @DisplayName("Ladder의 높이를 통해 LadderLeg 생성기를 생성한다.")
    public void createLadderGenerator() {
        Height height = new Height("5");

        LadderLegGenerator ladder = new LadderLegGenerator(height);

        assertInstanceOf(LadderLegGenerator.class, ladder);
    }

    @Test
    @DisplayName("가지가 없는 빈 LadderLeg 를 생성한다.")
    public void generateDownLadderLeg() {
        Height height = new Height("5");
        LadderLegGenerator ladder = new LadderLegGenerator(height);

        LadderLeg ladderLeg = ladder.generateDownLadderLeg();

        for (int i = 0; i < height.toInt(); i++) {
            assertEquals(ladderLeg.getDirectionAtIndex(i), Direction.DOWN);
        }
    }

    @Test
    @DisplayName("전 LadderLeg 와 DirectionGenerator 를 통해 가지를 가지는 LadderLeg 를 생성한다.")
    public void generateLadderLeg() {
        LadderLegGenerator ladderLegGenerator = 사다리_생성기_생성();
        List<Direction> fixedDirectionList = List
                .of(Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT);

        LadderLeg downLadderLeg = ladderLegGenerator.generateDownLadderLeg();
        LadderLeg ladderLeg = ladderLegGenerator
                .generateLadderLeg(downLadderLeg,
                        ()->new FixedDirectionGenerator(fixedDirectionList).generate());
        for (int i = 0; i < 5; i++) {
            assertEquals(ladderLeg.getDirectionAtIndex(i), fixedDirectionList.get(i));
        }
    }

    @Test
    @DisplayName("전 LadderLeg의 동일 index가 오른쪽 가지를 가질때, 왼쪽 가지를 가지는 LadderLeg 를 생성한다.")
    public void generateLeftDirectionLadderLeg() {
        LadderLegGenerator ladderLegGenerator = 사다리_생성기_생성();
        List<Direction> fixedDirectionList = List
                .of(Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT);

        LadderLeg rightLadderLeg =
                ladderLegGenerator.generateLadderLeg(
                        ladderLegGenerator.generateDownLadderLeg(),
                        () -> new FixedDirectionGenerator(fixedDirectionList).generate());

        LadderLeg testLeftLadderLeg =
                ladderLegGenerator.generateLadderLeg(
                        rightLadderLeg,
                        () -> new FixedDirectionGenerator(fixedDirectionList).generate());

        for (int i = 0; i < 5; i++) {
            assertEquals(testLeftLadderLeg.getDirectionAtIndex(i), Direction.LEFT);
        }
    }

    private LadderLegGenerator 사다리_생성기_생성() {
        Height height = new Height("5");
        return new LadderLegGenerator(height);
    }


}