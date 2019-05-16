package ladder.model;

import java.util.Objects;

public class Tag {
    private static final String VALUE_CONTAIN_SPACE_ERROR = "이름 공백 포함 오류";
    private static final String VALUE_LENGTH_ERROR = "이름 길이 5초과 오류";
    private static final String EMPTY_VALUE_ERROR = "빈 이름 오류";
    private static final String WHITE_SPACE = " ";
    private static final int VALUE_UPPER_BOUND = 5;
    private static final int VALUE_LOWER_BOUND = 0;

    private String value;

    public Tag(String value) {
        checkEmptyValue(value);
        checkValueLength(value);
        checkValueContainSpace(value);
        this.value = value;
    }

    private void checkEmptyValue(String value) {
        if (value.length() == VALUE_LOWER_BOUND) {
            throw new IllegalArgumentException(EMPTY_VALUE_ERROR);
        }
    }

    private void checkValueLength(String value) {
        if (value.length() > VALUE_UPPER_BOUND) {
            throw new IllegalArgumentException(VALUE_LENGTH_ERROR);
        }
    }

    private void checkValueContainSpace(String value) {
        if (value.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException(VALUE_CONTAIN_SPACE_ERROR);
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag value = (Tag) o;
        return getValue().equals(value.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
