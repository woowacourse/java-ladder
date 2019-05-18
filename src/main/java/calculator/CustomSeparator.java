package calculator;

import java.util.Objects;
import java.util.regex.Pattern;

public class CustomSeparator {

    private static final String SEPARATOR_REGEX = "([0-9]){1,}";

    private final String separator;

    public CustomSeparator(final String separator) {
        if (separator == null || separator.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (Pattern.matches(SEPARATOR_REGEX, separator)) {
            throw new IllegalArgumentException();
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
