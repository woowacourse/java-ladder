package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자의 이름은 ")
class NameTest {

    @DisplayName("5자 이하이다.")
    @Test
    public void nameTest_5() {
        Assertions.assertDoesNotThrow(() -> new Name("12345"));
    }

    @DisplayName("6자 이상이면 에러가 발생한다.")
    @Test
    public void nameTest_6() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Name("123456"));
    }

    @DisplayName("1자 이상이다.")
    @Test
    public void nameTest_1() {
        Assertions.assertDoesNotThrow(() -> new Name("1"));
    }

    @DisplayName("1자 미만이면 예외가 발생한다.")
    @Test
    public void nameTest_0() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Name(""));
    }

    @DisplayName("공백이 포함되면 예외가 발생한다.")
    @Test
    public void nameTest_blank() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Name("joy "));
    }
}