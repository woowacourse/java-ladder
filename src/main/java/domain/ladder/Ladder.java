package domain.ladder;

import domain.Point;
import domain.ladder.attribute.Direction;
import util.DirectionGenerator;
import domain.ladder.attribute.Height;

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

    public Point traverseLadderFromStartToEnd(final Point startPoint) {
        return Stream.iterate(startPoint, this::movePoint)
                     .filter(this::isPointIsEndLine)
                     .findFirst()
                     .orElseThrow(() -> new IllegalStateException("""
                             만족하는 결과가 없는 경우로 , 사다리가 잘못 생성되었습니다.
                             사다리를 다시 생성해주세요!
                             """));
    }

    private Point movePoint(Point point) {
        Direction direction = getDirectionWithRowAndColumn(point.row(), point.column());
        return point.move(direction);
    }

    private boolean isPointIsEndLine(Point point) {
        if (point.column() < height.getHeight()) {
            return false;
        }
        return true;
    }

    public Direction getDirectionWithRowAndColumn(final int row, final int column) {
        return ladderLegs.get(row)
                         .getDirectionAtIndex(column);
    }

    public int getHeight() {
        return height.getHeight();
    }


}
