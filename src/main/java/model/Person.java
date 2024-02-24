package model;

public class Person {
    private final PersonName personName;
    private Position position;

    private Person(final PersonName personName, final Position position) {
        this.personName = personName;
        this.position = position;
    }

    public static Person from(final String name, int column) {
        final Position startPosition = new Position(0, column);
        return new Person(new PersonName(name), startPosition);
    }

    public void climbDown(final Ladder ladder) {
        while (position.depth() < ladder.getLines().size()) {
            Line line = ladder.get(position.depth());
            moveHorizontally(line);
            moveBelow();
        }
    }

    public void moveHorizontally(Line line) {
        if (line.hasLeftPath(getColumn())) {
            position = position.getLeftPosition();
            return;
        }
        if (line.hasRightPath(getColumn())) {
            position = position.getRightPosition();
        }
    }

    public void moveBelow() {
        position = position.getBelowPosition();
    }

    public String getName() {
        return personName.name();
    }

    public int getDepth() {
        return position.depth();
    }

    public int getColumn() {
        return position.column();
    }
}
