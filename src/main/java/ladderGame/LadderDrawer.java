package ladderGame;

import java.util.Random;

public class LadderDrawer {
    private final Random rand = new Random();

    public void draw(Ladder ladder, int numToDraw) {
        int rows = ladder.getRows(), columns = ladder.getColumns();

        int numDrawn = 0;
        while (numDrawn < numToDraw) {
            numDrawn += tryDraw(ladder, rows, columns);
        }
    }

    private int tryDraw(Ladder ladder, int rows, int columns) {
        int row = rand.nextInt(rows);
        int column = rand.nextInt(columns);

        if (!ladder.canDraw(row, column)) {
            return 0;
        }

        ladder.draw(row, column);
        return 1;
    }
}
