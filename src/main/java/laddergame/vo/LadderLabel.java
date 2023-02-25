package laddergame.vo;

import laddergame.constant.ErrorCode;

import java.util.Objects;

public class LadderLabel {

    private static final int MAX_LABEL_LENGTH = 5;

    private final String value;

    public LadderLabel(String value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(String value) {
        if (value.isBlank() || value == null) {
            throw new IllegalArgumentException(ErrorCode.EMPTY_INPUT.getCode());
        }
        if (value.length() > MAX_LABEL_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.NOT_VALID_LADDER_LABEL_LENGTH.getCode());
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLabel that = (LadderLabel) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
