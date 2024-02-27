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


    public int moveCoordinateToResultPoint(int x, int y) {
        if (isReachResultPoint(y)) return x;
        Direction currentDirection = getDirectionOfLadderLegPieceAtSpecificCoordinate(x, y);
        if (currentDirection.equals(Direction.RIGHT)) {
            x += 1;
        }
        if (currentDirection.equals(Direction.LEFT)) {
            x -= 1;
        }
        y += 1;
        return moveCoordinateToResultPoint(x, y);
    }

    private Direction getDirectionOfLadderLegPieceAtSpecificCoordinate(int x, int y) {
        validateCoordinate(x, y);
        return ladderLegs.get(x)
                         .getDirectionAtIndex(y);
    }

    private boolean isReachResultPoint(int y) {
        return y == height.getValue();
    }

    public List<Direction> getDirectionsAtHorizontalIndex(int index) {
        validateVerticalIndex(index);
        return ladderLegs.stream()
                         .map(ladderLeg -> ladderLeg.getDirectionAtIndex(index))
                         .toList();
    }

    private void validateCoordinate(int x, int y) {
        validateHorizontalIndex(x);
        validateVerticalIndex(y);
    }

    private void validateHorizontalIndex(int index) {
        if (index < 0 || index >= this.width) {
            throw new IllegalArgumentException("존재하지 않은 LadderLeg를 조회하였습니다.");
        }
    }

    private void validateVerticalIndex(int index) {
        if (index < 0 || index >= this.height.getValue()) {
            throw new IllegalArgumentException("존재하지 않은 LadderLegPiece를 조회하였습니다.");
        }
    }

    public int getHeight() {
        return height.getValue();
    }
}
