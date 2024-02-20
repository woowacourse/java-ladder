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
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여자 이름의 길이가 0이면 예외가 발생한다.")
    void nameMinLengthTest() {
        String name = "";
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
