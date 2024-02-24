package domain.ladder;

import domain.ladder.attirbute.Direction;
import domain.ladder.attirbute.Height;
import util.DirectionGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int width;
    private final Height height;
    private final List<LadderLeg> ladderLegs;

    public Ladder(Height height, int width, DirectionGenerator directionGenerator) {
        this.height = height;
        this.width = width;

        this.ladderLegs = generateFirstToLastLegs(directionGenerator);
    }

    private List<LadderLeg> generateFirstToLastLegs(DirectionGenerator directionGenerator) {
        LadderLegGenerator ladderLegGenerator = new LadderLegGenerator(this.height);
        List<LadderLeg> generatedLadderLegs = new ArrayList<>();
        LadderLeg ladderLeg = ladderLegGenerator.generateDownLadderLeg();
        int beforeLastLegPosition = this.width - 1;
        for (int i = 0; i < beforeLastLegPosition; i++) {
            ladderLeg = ladderLegGenerator.generateLadderLeg(ladderLeg, directionGenerator::generate);
            generatedLadderLegs.add(ladderLeg);
        }
        generatedLadderLegs.add(ladderLegGenerator.generateLadderLeg(ladderLeg, () -> Direction.DOWN));
        return generatedLadderLegs;
    }

    public List<Direction> getDirectionAtHorizontalIndex(int index) {
        validateIndex(index);
        return ladderLegs.stream()
                         .map(ladderLeg -> ladderLeg.getDirectionAtIndex(index))
                         .toList();
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.width) {
            throw new IllegalArgumentException("존재하지 않은 LadderLeg를 조회하였습니다.");
        }
    }

    public int getHeight() {
        return height.toInt();
    }
}
