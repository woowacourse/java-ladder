package ladder.domain;

public class PlayerName {

    private static final int NAME_MAXIMUM_LENGTH = 5;
    private final String name;

    public PlayerName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if(name.isBlank() || name.length() > NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("플레이어의 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }
}
