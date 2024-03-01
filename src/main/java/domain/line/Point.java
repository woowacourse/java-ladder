package domain.line;

import domain.ColumnPosition;
import domain.connection.Connection;

public class Point {

    private final ColumnPosition columnPosition;
    private final Connection connection;

    public Point(ColumnPosition columnPosition, Connection connection) {
        this.columnPosition = columnPosition;
        this.connection = connection;
    }

    public ColumnPosition navigateNextPosition() {
        return columnPosition.nextPosition(connection.getMoveWeight());
    }

    public ColumnPosition getColumnPosition() {
        return columnPosition;
    }

    public Connection getConnection() {
        return connection;
    }
}
