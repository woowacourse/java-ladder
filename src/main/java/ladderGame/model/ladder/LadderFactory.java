package ladderGame.model.ladder;

import ladderGame.model.ladder.direction.DirectionGenerator;
import ladderGame.model.ladder.direction.RandomDirectionGenerator;

public class LadderFactory {
    public static Ladder generateLadder(int rows, int columns) {
        DirectionGenerator randomDirectionGenerator = new RandomDirectionGenerator();
        Ladder ladder = new Ladder(randomDirectionGenerator, rows, columns);
        return ladder;
    }
}
