package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    @Test
    @DisplayName("Players객체 생성 테스트")
    void makePlayers() {
        String names = "roy,poy,soy,koy";

        assertDoesNotThrow(() -> new Players(names));
    }

    @Test
    @DisplayName("플레이어 수가 한명일 경우 예외 발생")
    void validateMoreThanOnePlayer() {
        String names = "roy";

        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 두 명 이상 입력해야 합니다.");
    }
}
