package domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import domain.player.Name;
import domain.player.Player;
import domain.player.Players;
import domain.player.Position;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultRequestTest {

    @DisplayName("isAll은 내부의 message가 all이면 true를 반환한다.")
    @Test
    void is_all_true() {
        // given
        LadderResultRequest request = new LadderResultRequest("all");

        // when
        boolean result = request.isAll();

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("isAll은 내부의 message가 all이 아니면 false를 반환한다.")
    @Test
    void is_all_false() {
        // given
        LadderResultRequest request = new LadderResultRequest("notAll");

        // when
        boolean result = request.isAll();

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("isPlayerName은 존재하는 Player의 이름이면 true를 반환한다.")
    @Test
    void is_player_name_true() {
        // given
        Players players = generatePlayersByNames("neo", "jun");
        LadderResultRequest request = new LadderResultRequest("neo");

        // when
        boolean result = request.isPlayerName(players);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("isPlayerName은 존재하는 Player의 이름이면 false를 반환한다.")
    @Test
    void is_player_name_false() {
        // given
        Players players = generatePlayersByNames("neo", "jun");
        LadderResultRequest request = new LadderResultRequest("pobi");

        // when
        boolean result = request.isPlayerName(players);

        // then
        assertThat(result).isFalse();
    }

    private Players generatePlayersByNames(String... names) {
        return Arrays.stream(names)
                .map(Name::new)
                .map(name -> new Player(name, new Position(1)))
                .collect(collectingAndThen(toList(), Players::new));
    }
}
