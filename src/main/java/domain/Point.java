package domain;

public class Point {

    private final ColumnPosition columnPosition;
    private final Connection connection;

    public Point(ColumnPosition columnPosition, Connection connection) {
        this.columnPosition = columnPosition;
        this.connection = connection;
    }

    public ColumnPosition navigateNextPosition() {
        return columnPosition.nextPosition(connection.getDirection());
    }

    public ColumnPosition getColumnPosition() {
        return columnPosition;
    }

    public Connection getConnection() {
        return connection;
    }
}
