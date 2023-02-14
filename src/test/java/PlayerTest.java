import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("6글자 이상 입력될 경우 예외 발생")
    @Test
    void errorAboutNameLimit() {
        String inputName = "abcdef";
        assertThatThrownBy(() ->
                new Player(inputName)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사람 이름은 최대 5글자 입니다.");
    }

    @DisplayName("5글자이면 player 객체가 생성")
    @Test
    void noError() {
        String inputName = "abcde";
        assertDoesNotThrow(() -> new Player(inputName));

    }
}
