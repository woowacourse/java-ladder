package ladderGame.model.ladder;

public class LadderFactory {
    public static Ladder generateLadder(int rows, int columns) {
        RandomBridgeGenerator randomBridgeGenerator = new RandomBridgeGenerator(rows, columns);
        Ladder ladder = new Ladder(randomBridgeGenerator, rows, columns);
        return ladder;
    }

    private static int getMaxTruePointNum(int rows, int columns) {
        if (isOddNumber(rows)) {
            return (rows / 2 + 1) * columns;
        }
        return (rows / 2) * columns;
    }

    private static boolean isOddNumber(int rows) {
        return rows % 2 == 1;
    }

}
