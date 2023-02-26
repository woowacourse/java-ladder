package ladder.domain;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;

    private int position;
    private final String name;

    public Player(final String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public Player(final String name, final int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("참여자의 이름은 최대 " + MAX_NAME_LENGTH + "글자를 넘을 수 없습니다.\n" + "Name : " + name);
        }
        if (!name.replace(" ", "").equals(name)) {
            throw new IllegalArgumentException("참여자의 이름에는 공백이 들어갈 수 없습니다.\n" + "Name : " + name);
        }
    }

    public void move(Direction direction) {
        if (direction == Direction.LEFT) {
            this.position--;
        }

        if (direction == Direction.RIGHT) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
