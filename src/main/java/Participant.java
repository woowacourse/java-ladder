public class Participant {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        if (name == null) {
            throw new IllegalArgumentException("참가자의 이름은 null 이거나 공백일 수 없습니다.");
        }
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("참여자의 이름은 최대 5글자입니다.");
        }
    }
}
