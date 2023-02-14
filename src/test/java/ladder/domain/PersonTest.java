package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.text.MessageFormat;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PersonTest {

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"pobi", "CRONG", "EddY"})
    @DisplayName("이름은 영문자만 가능합니다.")
    void personNameFormatTest(final String name) {
        assertThatNoException().isThrownBy(() -> new Person(name));
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"", "po bi", "세종대왕", "123", "!@#$%"})
    @DisplayName("이름이 영문자가 아니라면 예외를 던진다.")
    void throwExceptionWhenNameNotEnglish(final String name) {
        assertThatThrownBy(() -> new Person(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageFormat.format("사람 이름은 영문자만 가능합니다. 현재 입력은 {0} 입니다.", name));
    }

    @Test
    @DisplayName("이름에 NULL이 들어오면 예외를 던진다.")
    void throwExceptionWhenNameIsNull() {
        assertThatThrownBy(() -> new Person(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("5글자가 넘어가는 이름은 예외를 던진다.")
    void throwExceptionWhenNameLengthOverFive() {
        final String name = "abcdef";

        assertThatThrownBy(() -> new Person(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

class Person {

    private static final Pattern NAME_FORMAT = Pattern.compile("[a-zA-Z]+");
    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_FORMAT_ERROR_MESSAGE = "사람 이름은 영문자만 가능합니다. 현재 입력은 {0} 입니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE =
            "사람 이름은 " + NAME_MAX_LENGTH + "글자까지 가능합니다. 현재 입력은 {0} 입니다.";

    private final String name;

    public Person(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validateNameFormat(name);
        validateNameLength(name);
    }

    private void validateNameFormat(final String name) {
        if (isNotEnglish(name)) {
            throw new IllegalArgumentException(MessageFormat.format(NAME_FORMAT_ERROR_MESSAGE, name));
        }
    }

    private boolean isNotEnglish(final String name) {
        return !NAME_FORMAT.matcher(name).matches();
    }

    private void validateNameLength(final String name) {
        if (hasExceedLength(name)) {
            throw new IllegalArgumentException(MessageFormat.format(NAME_LENGTH_ERROR_MESSAGE, name));
        }
    }

    private boolean hasExceedLength(final String name) {
        return name.length() > NAME_MAX_LENGTH;
    }
}
