package calculator;

import java.util.Objects;
import java.util.regex.Pattern;

public class CustomSeparator {

    private static final String SEPARATOR_REGEX = "([0-9])+";

    private final String separator;

    public CustomSeparator(final String separator) {
        if (separator == null || separator.isEmpty()) {
            throw new IllegalArgumentException("구분자는 1글자로 구성되어야 합니다.");
        }
        if (Pattern.matches(SEPARATOR_REGEX, separator)) {
            throw new IllegalArgumentException("구분자는 숫자가 포함될 수 없습니다.");
        }
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomSeparator that = (CustomSeparator) o;
        return Objects.equals(separator, that.separator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(separator);
    }
}
