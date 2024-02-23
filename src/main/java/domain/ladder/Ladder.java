package domain.ladder;

import domain.ladder.attirbute.Direction;
import util.DirectionGenerator;
import domain.ladder.attirbute.Height;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Integer playerCount;
    private final Height height;
    private final List<LadderLeg> ladderLegs;

    public Ladder(Height height, Integer playerCount, DirectionGenerator directionGenerator) {
        this.height = height;
        this.playerCount = playerCount;

        this.ladderLegs = generateFirstToLastLegs(directionGenerator);
    }

    private List<LadderLeg> generateFirstToLastLegs(DirectionGenerator directionGenerator) {
        LadderLegGenerator ladderLegGenerator = new LadderLegGenerator(this.height);

        List<LadderLeg> ladderLegs = new ArrayList<>();
        LadderLeg ladderLeg = ladderLegGenerator.generateDownLadderLeg();
        for (int i = 0; i < this.playerCount - 1; i++) {
            ladderLeg = ladderLegGenerator.generateLadderLeg(ladderLeg, directionGenerator::generate);
            ladderLegs.add(ladderLeg);
        }
        ladderLegs.add(ladderLegGenerator.generateLadderLeg(ladderLeg, () -> Direction.DOWN));
        return ladderLegs;
    }


    public List<Direction> getDirectionAtHorizontalIndex(Integer index) {
        return ladderLegs.stream()
                         .map(ladderLeg -> ladderLeg.getDirectionAtIndex(index))
                         .toList();
    }

    public int getHeight(){
        return height.toInt();
    }

}
