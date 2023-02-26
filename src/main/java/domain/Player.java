package domain;

public class Player {

    private static final String ALL = "all";
    private static final String FORBIDDEN_NAME_MESSAGE = "all은 사용할 수 없는 이름입니다.";

    private final Name name;

    public Player(final String name) {
        validate(name);
        this.name = new Name(name);
    }

    private void validate(final String name) {
        validateForbidden(name);
    }

    private void validateForbidden(final String name) {
        if (name.equals(ALL)) {
            throw new IllegalArgumentException(FORBIDDEN_NAME_MESSAGE);
        }
    }

    public boolean hasSameName(final Name name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name.getName();
    }
}
