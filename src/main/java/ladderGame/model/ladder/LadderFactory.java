package ladderGame.model.ladder;

public class LadderFactory {
    public static Ladder generateLadder(int rows, int columns) {
        int randomNum = (int)(Math.random() * (getMaxTruePointNum(rows, columns)));
        Ladder ladder = new Ladder(rows, columns);

        while(ladder.getTruePointNumber() < randomNum) {
            int randomRowNumber = (int)(Math.random() * rows);
            int randomColumnNumber = (int)(Math.random() * columns);
            ladder.draw(randomRowNumber, randomColumnNumber);
        }
        return ladder;
    }

    private static int getMaxTruePointNum(int rows, int columns) {
        return rows % 2 == 1? (rows / 2 + 1) * columns : (rows / 2) * columns;
    }
}
