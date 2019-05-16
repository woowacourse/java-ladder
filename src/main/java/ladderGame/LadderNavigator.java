package ladderGame;

public class XXX {
    public static int YYY(DrawnLadder drawnLadder, int fromColumn) {
        int rows = drawnLadder.getRows();
        int toColumn = fromColumn;

        for (int row = 0; row < rows; row++) {
            toColumn = getToColumn(drawnLadder, toColumn, row);
        }
        return toColumn;
    }

    private static int getToColumn(DrawnLadder drawnLadder, int row, int toColumn) {
        if (hasToMoveLeft(drawnLadder, row, toColumn)) {
            return toColumn - 1;
        }

        if (hasToMoveRight(drawnLadder, row, toColumn)) {
            return toColumn + 1;
        }
        return toColumn;
    }

    private static boolean hasToMoveLeft(DrawnLadder drawnLadder, int row, int column) {
        return 0 <= (column - 1) && drawnLadder.isDrawn(row, column - 1);
    }

    private static boolean hasToMoveRight(DrawnLadder drawnLadder, int row, int column) {
        int columns = drawnLadder.getColumns();
        return column < columns && drawnLadder.isDrawn(row, column);
    }
}
