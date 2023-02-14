package ladder;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("참여자의 이름은 최대 " + MAX_NAME_LENGTH + "글자를 넘을 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
