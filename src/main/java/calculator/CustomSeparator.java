package calculator;

import java.util.Objects;
import java.util.regex.Pattern;

public class CustomSeparator {
    private final String separator;

    public CustomSeparator(final String separator) {
        if (separator == null || separator.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자를 넣어주세요.");
        }
        if (Pattern.matches("([0-9])+", separator)) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자 이외의 문자여야 합니다.");
        }
        this.separator = separator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomSeparator that = (CustomSeparator) o;
        return Objects.equals(separator, that.separator);
    }

    public String getSeparator() {
        return separator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(separator);
    }
}
