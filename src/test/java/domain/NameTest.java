package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class NameTest {
    @DisplayName("이름은 5자 이하이다.")
    @Test
    public void nameTest_5() {
        Assertions.assertDoesNotThrow(() -> new Name("12345"));
    }

    @DisplayName("이름이 6자 이상이면 에러가 발생한다.")
    @Test
    public void nameTest_6() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Name("123456"));
    }
}