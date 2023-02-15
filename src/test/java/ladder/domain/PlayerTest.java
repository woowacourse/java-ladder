package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.text.MessageFormat;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"pobi", "CRONG", "EddY"})
    @DisplayName("이름은 영문자만 가능합니다.")
    void personNameFormatTest(final String name) {
        assertThatNoException().isThrownBy(() -> new Player(name));
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"", "po bi", "세종대왕", "123", "!@#$%"})
    @DisplayName("이름이 영문자가 아니라면 예외를 던진다.")
    void throwExceptionWhenNameNotEnglish(final String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageFormat.format("사람 이름은 영문자만 가능합니다. 현재 입력은 {0} 입니다.", name));
    }

    @Test
    @DisplayName("이름에 NULL이 들어오면 예외를 던진다.")
    void throwExceptionWhenNameIsNull() {
        assertThatThrownBy(() -> new Player(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("5글자가 넘어가는 이름은 예외를 던진다.")
    void throwExceptionWhenNameLengthOverFive() {
        final String name = "abcdef";

        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"pobi  ", " crong", "   eddy      "})
    @DisplayName("이름 양끝에 공백이 있다면 공백을 제거한다.")
    void trimNameBothEndsBlank(final String name) {
        assertThatNoException().isThrownBy(() -> new Player(name));
    }
}

class Player {

    private static final Pattern NAME_FORMAT = Pattern.compile("[a-zA-Z]+");
    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_FORMAT_ERROR_MESSAGE = "사람 이름은 영문자만 가능합니다. 현재 입력은 {0} 입니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE =
            "사람 이름은 " + NAME_MAX_LENGTH + "글자까지 가능합니다. 현재 입력은 {0} 입니다.";

    private final String name;

    public Player(final String name) {
        final String trimName = name.trim();
        validate(trimName);
        this.name = trimName;
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

    public String getName() {
        return name;
    }
}
