package ladderGame.model.ladder;

public class RandomBridgeGenerator {
    private final int rows;
    private final int columns;

    public RandomBridgeGenerator(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    private static int getMaxBridgeNum(int rows, int columns) {
        if (isOddNumber(rows)) {
            return (rows / 2 + 1) * columns;
        }
        return (rows / 2) * columns;
    }

    private static boolean isOddNumber(int rows) {
        return rows % 2 == 1;
    }

    public Location generateRandomBridgeLocation() {
        int randomRow = (int) (Math.random() * rows);
        int randomColumn = (int) (Math.random() * columns);

        return new Location(randomRow, randomColumn);
    }

    public int generateRandomBridgeCount() {
        int maxBridgeNum = getMaxBridgeNum(rows, columns);

        return (int) (Math.random() * maxBridgeNum);
    }
}
