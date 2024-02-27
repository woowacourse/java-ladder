import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import domain.Player;
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
        Players players = Players.from(List.of("kirby", "bito", "ready"));

        // when & then
        assertThat(players.getCount()).isEqualTo(3);
    }

    @Test
    void validSearch() {
        Players players = Players.from(List.of("pobi", "kirby"));
        assertThat(players.search("pobi").getPlayers()).containsExactly(new Player("pobi"));
    }
    @Test
    void invalidSearch() {
        Players players = Players.from(List.of("pobi", "kirby"));
        assertThatIllegalArgumentException().isThrownBy(() -> players.search("abc"));
    }

    @Test
    void search() {
        Players players = Players.from(List.of("pobi", "kirby"));
        Players pobi = players.search("pobi");
        assertThat(pobi.getPlayers()).containsExactly(new Player("pobi"));
    }
}
