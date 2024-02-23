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


    public List<Direction> getDirectionAtHorizontalIndex(Integer index) {
        return ladderLegs.stream()
                         .map(ladderLeg -> ladderLeg.getDirectionAtIndex(index))
                         .toList();
    }

    public int getHeight() {
        return height.toInt();
    }

}
