package domain.ladder;

import domain.ladder.common.Direction;
import util.DirectionGenerator;
import domain.ladder.common.Height;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        int heightValue = height.getHeight();
        List<LadderLeg> ladderLegs = Stream.iterate(LadderLeg.downLadderLeg(heightValue), prevLeg ->
                                                   LadderLeg.from(prevLeg, heightValue, directionGenerator::generate))
                                           .limit(playerCount - 1)
                                           .collect(Collectors.toList());

        ladderLegs.add(LadderLeg.from(ladderLegs.get(ladderLegs.size() - 1), heightValue, () -> Direction.DOWN));
        return ladderLegs;
    }


    public List<Direction> getDirectionAtHorizontalIndex(Integer index) {
        return ladderLegs.stream()
                         .map(ladderLeg -> ladderLeg.getDirectionAtIndex(index))
                         .toList();
    }

    public int getHeight() {
        return height.getHeight();
    }

}
