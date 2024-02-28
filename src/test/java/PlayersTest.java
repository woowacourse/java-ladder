import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import domain.Players;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {
    @Test
    @DisplayName("중복된 이름이 없는 경우 정상적으로 참가자들을 생성한다.")
    void invalidPlayers() {
        assertThatCode(() -> Players.from(List.of("kirby", "bito", "ready"))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("중복된 이름이 있는 경우 예외를 발생시킨다.")
    void validPlayers() {
        assertThatIllegalArgumentException().isThrownBy(() -> Players.from(List.of("kirby", "bito", "bito")));
    }

    @Test
    @DisplayName("참가자들의 인원수를 반환한다.")
    void getCount() {
        // given
        final Players players = Players.from(List.of("kirby", "bito", "ready"));

        // when & then
        assertThat(players.getCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("존재하지 않는 사용자가 입력되면 예외를 발생한다.")
    void validateNotExistPlayer() {
        // given
        final Players players = Players.from(List.of("pobi", "kirby"));

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> players.validateExistPlayer("hi"));
    }

    @Test
    @DisplayName("존재하는 사용자가 입력되면 예외를 발생하지 않는다.")
    void validateExistPlayer() {
        // given
        final Players players = Players.from(List.of("pobi", "kirby"));

        // when & then
        assertThatCode(() -> players.validateExistPlayer("pobi")).doesNotThrowAnyException();
    }
}
