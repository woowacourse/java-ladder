package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사용자의 이름은 ")
class NameTest {

    @DisplayName("5자 이하이다.")
    @ParameterizedTest
    @ValueSource(strings = {"5자이하", "1234", "12345"})
    public void nameTest_5(String name) {
        Assertions.assertDoesNotThrow(() -> new Name(name));
    }

    @DisplayName("6자 이상이면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"6자이상문자열", "123456", "1234567"})
    public void nameTest_6(String name) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Name(name));
    }

    @DisplayName("1자 이상이다.")
    @ParameterizedTest
    @ValueSource(strings = {"1자이상", "1", "12"})
    public void nameTest_1(String name) {
        Assertions.assertDoesNotThrow(() -> new Name(name));
    }

    @DisplayName("1자 미만이면 예외가 발생한다.")
    @Test
    public void nameTest_0() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Name(""));
    }

    @DisplayName("공백이 포함되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"중간 공백", " 시작공백", "끝공백 "})
    public void nameTest_blank(String name) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Name(name));
    }
}