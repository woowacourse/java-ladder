package domain.player;

public class Name {
    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String LENGTH_EXCEPTION_MESSAGE = "[ERROR] 잘못된 이름: %s - 이름의 길이는 %d ~ %d 글자여야 합니다.";

    private final String name;

    public Name(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(final String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(LENGTH_EXCEPTION_MESSAGE, name, MINIMUM_NAME_LENGTH, MAXIMUM_NAME_LENGTH)
            );
        }
    }

    public String getValue() {
        return this.name;
    }

    public int getLength() {
        return this.name.length();
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
