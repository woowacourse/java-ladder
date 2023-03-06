package domain;

public class Player {

    private static final int MAXIMUM_LENGTH_OF_LETTERS = 5;

    private final String name;
    private int position;

    public Player(String name, int position) {
        validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_LENGTH_OF_LETTERS) {
            throw new IllegalArgumentException("[ERROR] 사람 이름은 최대 5글자 입니다.");
        }
    }

    public void moveToRight() {
        this.position++;
    }

    public void moveToLeft() {
        this.position--;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }
}
