package domain.player;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String SPACE = " ";

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
        validateSpace(name);
    }

    private void validateLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("참가자 이름의 길이는 1이상 5이하만 가능합니다.");
        }
    }

    private void validateSpace(String name) {
        if (name.contains(SPACE)) {
            throw new IllegalArgumentException("참가자 이름에는 공백이 들어갈 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
