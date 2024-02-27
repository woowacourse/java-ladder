package domain.player;

public class Name {
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String RESERVED_KEYWORD = "all";
    public static final String RESERVED_EXCEPTION_MESSAGE = "[ERROR] 이름으로 " + RESERVED_KEYWORD + "을 입력할 수 없습니다.";
    private static final String LENGTH_EXCEPTION_MESSAGE = "[ERROR] 이름의 길이는 " + MINIMUM_NAME_LENGTH +
            "보다 크거나, " + MAXIMUM_NAME_LENGTH + "보다 작아야합니다.";

    private final String name;

    public Name(String name) {
        validateLength(name);
        validateReserved(name);
        this.name = name;
    }

    private void validateLength(final String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void validateReserved(final String name) {
        if (name.equals(RESERVED_KEYWORD)) {
            throw new IllegalArgumentException(RESERVED_EXCEPTION_MESSAGE);
        }
    }

    public String getValue() {
        return name;
    }

    public int getLength() {
        return name.length();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Name name) {
            return this.name.equals(name.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
