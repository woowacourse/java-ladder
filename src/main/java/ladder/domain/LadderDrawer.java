package ladder.domain;

import java.util.stream.IntStream;

public class LadderDrawer {
    public static void tryDraw(Ladder ladder, int numTrial) {
        RandomPositionGenerator rowPositionGenerator = new RandomPositionGenerator(ladder.createFirstRowPosition(), System.currentTimeMillis());
        RandomPositionGenerator columnPositionGenerator = new RandomPositionGenerator(ladder.createFirstLeftColumnPosition(), System.currentTimeMillis() + 4321);

        Position firstColumnPosition = ladder.createFirstColumnPosition();
        IntStream.range(0, numTrial).forEach((i) -> {
            Position row = rowPositionGenerator.generate();
            // Todo: 이쁘게... 좀 많이 복잡하다
            Position column = firstColumnPosition.plus(columnPositionGenerator.generate().toInt());

            if (ladder.canDraw(row, column)) {
                ladder.draw(row, column);
            }
        });
    }
}
