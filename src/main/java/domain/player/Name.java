package domain.player;

import java.util.Objects;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private final String value;

    public Name(String name) {
        validate(name);
        this.value = name;
    }

    public String getValue() {
        return value;
    }

    private void validate(String name) {
        boolean isBlank = name.isBlank();
        boolean isInvalidLength = name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
        if (isBlank || isInvalidLength) {
            throw new IllegalArgumentException("1글자 이상 5글자 이하의 이름만 입력해주세요.");
        }
        if (name.equals("all")) {
            throw new IllegalArgumentException("all만은 안됩니다ㅠㅠ");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(value, name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
