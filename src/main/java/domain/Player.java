package domain;

public class Player {

    private static final int MAXIMUM_LENGTH = 5;

    private final String name;
    private int position;

    public Player(String name, int position) {
        validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 사람 이름은 최대 5글자 입니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public void moveToRight() {
        this.position++;
    }

    public void moveToLeft() {
        this.position--;
    }

    public int getPosition() {
        return position;
    }

}
