package ladder.domain.participant;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String FORBIDDEN_NAME = "all";

    private final String name;

    Participant(final String name) {
        validateNameLength(name);
        validateForbiddenName(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 " + MAX_NAME_LENGTH + "글자가 넘어갑니다.");
        }
    }

    private void validateForbiddenName(String name) {
        if (name.toLowerCase().equals(FORBIDDEN_NAME)) {
            throw new IllegalArgumentException("명령어(all)는 이름으로 사용할 수 없습니다");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
