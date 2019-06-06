package ladderGame.model.ladder;

public class LadderFactory {
    public static Ladder generateLadder(int rows, int columns) {
        RandomBridgeGenerator randomBridgeGenerator = new RandomBridgeGenerator(rows, columns);
        Ladder ladder = new Ladder(randomBridgeGenerator, rows, columns);
        return ladder;
    }
}
