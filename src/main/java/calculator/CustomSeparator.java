package calculator;

import java.util.Objects;
import java.util.regex.Pattern;

public class CustomSeparator {

    private final String separator;

    public CustomSeparator(final String separator) {
        if(separator == null){
            throw new IllegalArgumentException();
        }
        if(separator.length() != 1){
            throw new IllegalArgumentException();
        }
        if(Pattern.matches("([0-9]){1,}",separator)){
            throw new IllegalArgumentException();
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
