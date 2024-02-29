package domain;

public class Player {

    private final Name name;
    private final ColumnPosition columnPosition;

    public Player(Name name, ColumnPosition columnPosition) {
        this.name = name;
        this.columnPosition = columnPosition;
    }

    public String getName() {
        return name.getName();
    }

    public int getColumnPosition() {
        return columnPosition.getColumnPosition();
    }
}
