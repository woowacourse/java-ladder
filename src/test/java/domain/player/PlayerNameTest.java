package domain.player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerNameTest {

    @DisplayName("참가자의 이름이 5글자 이하이면 잘 생성된다.")
    @Test
    void createPlayerName() {
        //given & when & then
        assertThatCode(() -> new PlayerName("abc12"))
                .doesNotThrowAnyException();
    }

    @DisplayName("참가자의 이름이 5글자를 초과하면 예외가 발생한다.")
    @Test
    void tooLongPlayerName() {
        //given & when & then
        assertThatThrownBy(() -> new PlayerName("abc123"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
