package domain.player;

import static common.ReservedKeywords.ALL;

public class Name {
    public static final String RESERVED_EXCEPTION_MESSAGE = "[ERROR] 이름으로 %s을 입력할 수 없습니다.";
    private static final String LENGTH_EXCEPTION_MESSAGE = "[ERROR] 이름의 길이는 %d보다 크거나, %d보다 작아야합니다.";
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;


    private final String name;

    public Name(String name) {
        validateLength(name);
        validateReserved(name);
        this.name = name;
    }

    private void validateLength(final String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(LENGTH_EXCEPTION_MESSAGE, MINIMUM_NAME_LENGTH, MAXIMUM_NAME_LENGTH));
        }
    }

    private void validateReserved(final String name) {
        if (name.equals(ALL)) {
            throw new IllegalArgumentException(String.format(RESERVED_EXCEPTION_MESSAGE, ALL));
        }
    }

    public String getValue() {
        return name;
    }
}
