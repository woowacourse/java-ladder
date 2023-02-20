package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class PlayersTest {

    @Test
    @DisplayName("두 명 보다 적은 플레이어를 입력하면 예외 발생")
    void validatePlayersSize() {
        Assertions.assertThatThrownBy(() -> new Players(List.of("a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 2명 이상 입력해야 합니다.");
    }

    @Test
    @DisplayName("중복된 닉네임을 입력하면 예외 발생")
    void validateDuplicateName() {
        Assertions.assertThatThrownBy(() -> new Players(List.of("a", "b", "a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름입니다.");
    }
}
