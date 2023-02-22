package domain;

public class Person {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;
    public static final String NAME_LENGTH_FORMAT = "이름은 %d자 이상 %d자 이하여야 합니다";

    private final String name;
    private Position position;

    public Person(String name) {
        this(name, 0);
    }

    public Person(String name, int position) {
        validateNameLength(name);
        this.name = name;
        this.position = new Position(position);
    }

    private void validateNameLength(String name) {
        if (name.isBlank() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                String.format(NAME_LENGTH_FORMAT, MIN_LENGTH, MAX_LENGTH));
        }
    }

    public String getName() {
        return name;
    }

    public void move(ShiftType shiftType) {
        if (ShiftType.LEFT.equals(shiftType)) {
            moveLeft();
            return;
        }
        if (ShiftType.RIGHT.equals(shiftType)) {
            moveRight();
        }
    }

    private void moveLeft() {
        position = position.minus();
    }

    private void moveRight() {
        position = position.plus();
    }

    public Position getPosition() {
        return position;
    }
}
