package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @Test
    @DisplayName("참여자 이름의 길이가 5를 초과하면 예외가 발생한다.")
    void nameMaxLengthTest() {
        String name = "name12";
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 5를 초과할 수 없다.");
    }

    @Test
    @DisplayName("참여자 이름의 길이가 0이면 예외가 발생한다.")
    void nameMinLengthTest() {
        String name = "";
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 비어 있습니다.");
    }

    @Test
    @DisplayName("참여자 이름에 영문자와 숫자가 아닌 문자가 포함될 경우 예외가 발생한다.")
    void nameFormatTest() {
        String name = "test!";
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 영문자와 숫자로 구성되어야 합니다.");
    }
}
