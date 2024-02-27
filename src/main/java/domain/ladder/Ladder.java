package domain.ladder;

import domain.Point;
import domain.ladder.common.Direction;
import util.DirectionGenerator;
import domain.ladder.common.Height;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final Integer playerCount;
    private final Height height;
    private final List<LadderLeg> ladderLegs;

    public Ladder(Height height, Integer playerCount, DirectionGenerator directionGenerator) {
        this.height = height;
        this.playerCount = playerCount;
        this.ladderLegs = generateLadderLegs(directionGenerator);
    }

    private List<LadderLeg> generateLadderLegs(DirectionGenerator directionGenerator) {
        int heightValue = height.getHeight();

        List<LadderLeg> ladderLegs = buildBeforeFinalLeg(heightValue, directionGenerator);
        addFinalLeg(heightValue, ladderLegs);
        return ladderLegs;
    }

    private List<LadderLeg> buildBeforeFinalLeg(int heightValue, DirectionGenerator directionGenerator) {
        LadderLeg initialLeg = LadderLeg.downLadderLeg(heightValue);
        return Stream.iterate(initialLeg, prevLeg ->
                             LadderLeg.fromPreviousWithDynamicDirection(prevLeg, heightValue, directionGenerator::generate))
                     .skip(1)
                     .limit(playerCount - 1)
                     .collect(Collectors.toList());
    }

    private void addFinalLeg(int heightValue, List<LadderLeg> ladderLegs) {
        ladderLegs.add(
                LadderLeg
                        .fromPreviousWithDownDirection(ladderLegs.get(ladderLegs.size() - 1), heightValue));
    }


    public List<Direction> getDirectionAtHorizontalIndex(Integer index) {
        return ladderLegs.stream()
                         .map(ladderLeg -> ladderLeg.getDirectionAtIndex(index))
                         .toList();
    }

    public int getHeight() {
        return height.getHeight();
    }

    public Direction getDirectionWithPoint(final Point point) {
        return ladderLegs.get(point.row())
                         .getDirectionAtIndex(point.column());
    }
}
