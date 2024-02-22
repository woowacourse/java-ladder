package domain.ladder;

import domain.ladder.common.Direction;
import util.DirectionGenerator;
import domain.ladder.common.Height;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Integer playerCount;
    private final Height height;
    private final List<LadderLeg> ladderLegs;

    public Ladder(Height height, Integer playerCount, DirectionGenerator directionGenerator) {
        this.height = height;
        this.playerCount = playerCount;
        List<LadderLeg> ladderLegs = new ArrayList<>();
        generateFirstToLastLegs(ladderLegs, directionGenerator);
        this.ladderLegs = ladderLegs;
    }
    public int getHeight(){
        return height.getHeight();
    }

    public List<LadderLeg> getLadderLegs() {
        return ladderLegs;
    }

    private void generateFirstToLastLegs(List<LadderLeg> ladderLegs, DirectionGenerator directionGenerator) {

        LadderLegGenerator ladderLegGenerator = new LadderLegGenerator(this.height);
        LadderLeg ladderLeg = ladderLegGenerator.generateDownLadderLeg();
        for (int i = 0; i < playerCount - 1; i++) {
            ladderLeg = ladderLegGenerator.generateLadderLeg(ladderLeg, directionGenerator::generate);
            ladderLegs.add(ladderLeg);
        }
        ladderLegs.add(ladderLegGenerator.generateLadderLeg(ladderLeg, () -> Direction.DOWN));
    }

    public List<Direction> getDirectionAtHorizontalIndex(Integer index) {
        return ladderLegs.stream()
                         .map(ladderLeg -> ladderLeg.getDirectionAtIndex(index))
                         .toList();
    }

    public int getHeight(){
        return height.getHeight();
    }

}
