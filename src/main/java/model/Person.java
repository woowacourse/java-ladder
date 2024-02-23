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
