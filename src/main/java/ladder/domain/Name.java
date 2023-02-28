package ladder.domain;

import java.util.Objects;

/**
 * name의 null check의 경우 Name생성자를 호출하는 Names 클래스에 구현되어 있기 때문에 생략하였습니다.
 */
class Name {

    public static final int MAX_NAME_LENGTH = 5;

    private final String value;

    Name(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(String value) {
        if (isOverLength(value)) {
            throw new IllegalArgumentException(String.format("글자수가 %d글자를 초과했습니다", MAX_NAME_LENGTH));
        }
        if (isBlank(value)) {
            throw new IllegalArgumentException("이름이 빈 문자열이 될 수 없습니다");
        }
    }

    private boolean isBlank(String value) {
        return value.isBlank();
    }

    private boolean isOverLength(String value) {
        return value.length() > MAX_NAME_LENGTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    String getValue() {
        return value;
    }
}
