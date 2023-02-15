package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @DisplayName("참여자 이름은 5글자를 초과할 수 없다.")
    @Test
    void playerNameNotMoreThan5() {
        String playerName = "abcdef";
        assertThatThrownBy(() -> new Player(playerName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈문자열을 입력하면 예외가 발생한다.")
    @Test
    void playerNameNotBlank() {
        String playerName = "";
        assertThatThrownBy(() -> new Player(playerName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1글자 이상 5글자 이하이면 정상적으로 객체를 생성한다.")
    @Test
    void playerName_정상() {
        String playerName = "abcde";
        assertThatNoException()
                .isThrownBy(() -> new Player(playerName));
    }
}
