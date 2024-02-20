import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {

    @DisplayName("플레이어 객체를 정상적으로 생성한다.")
    @Test
    void createPlayer() {
        assertThatCode(() -> new Player("dodo"))
                .doesNotThrowAnyException();
    }

    @DisplayName("플레이어의 이름이 5자 초과이면 예외가 발생한다.")
    @Test
    void createPlayerWithOverNameSize() {
        assertThatThrownBy(() -> new Player("dodododo"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("플레이어의 이름이 영어가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"도도","c!apy","123"})
    void createPlayerWithNotEnglish(String invalidName) {
        assertThatThrownBy(()-> new Player(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
