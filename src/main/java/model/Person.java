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
        while (ladder.isWithinLadderRange(position)) {
            final Line line = ladder.get(position);
            moveHorizontally(line);
            moveBelow();
        }
    }

    private void moveHorizontally(Line line) {
        position = line.getNextHorizontalPosition(position);
    }

    private void moveBelow() {
        position = position.getBelowPosition();
    }

    public PersonName getPersonName() {
        return personName;
    }

    public int getDepth() {
        return position.depth();
    }

    public int getColumn() {
        return position.column();
    }
}
