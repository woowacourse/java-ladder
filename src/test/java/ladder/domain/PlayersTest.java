package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {
    @DisplayName("중복된 사용자가 입력되면 예외가 발생한다.")
    @Test
    void duplicatedNameTest() {
        Player player = new Player(new Name("명오"));
        assertThatThrownBy(() -> new Players(List.of(player, player)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름은 입력할 수 없습니다: %s".formatted("명오"));
    }

    @DisplayName("입력된 사용자가 하나면 예외가 발생한다.")
    @Test
    void OneNameTest() {
        assertThatThrownBy(() -> new Players(List.of(new Player(new Name("명오")))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자는 최소 2명입니다.");
    }

    @DisplayName("사람 수를 반환한다.")
    @Test
    void playersCountTest() {
        Players players = new Players(List.of(new Player(new Name("명오")), new Player(new Name("제우스"))));
        assertThat(players.count()).isEqualTo(2);
    }

    @DisplayName("사다리를 입력하면 사다리를 탄 전체 결과를 반환한다.")
    @Test
    void climbAllPlayers() {
        Players players = new Players(List.of(new Player(new Name("명오")), new Player(new Name("제우스"))));
        Ladder ladder = new Ladder(new Width(2), new Height(3), () -> RIGHT);

        List<Player> climbedPlayers = players.climbAllPlayers(ladder).stream().toList();

        assertThat(climbedPlayers).extracting(Player::location).containsOnly(new Location(1));
    }
}
