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
                .hasMessage(Players.SIZE_ERROR);
    }

    @Test
    @DisplayName("중복된 닉네임을 입력하면 예외 발생")
    void validateDuplicateName() {
        Assertions.assertThatThrownBy(() -> new Players(List.of("a", "b", "a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Players.DUPLICATE_NAME_ERROR);
    }

    @Test
    @DisplayName("존재하지 않는 TargetPlayer를 입력시 예외 발생")
    void validateTargetPlayer() {
        Players players = new Players(List.of("a", "b", "c"));
        Assertions.assertThatThrownBy(() -> players.validateTargetPlayer("d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Players.TARGET_PLAYER_EXIST_ERROR);
    }
}
