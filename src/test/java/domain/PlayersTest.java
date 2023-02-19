package domain;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("Player가 두 명 이상일 경우 정상적으로 생성된다.")
    @Test
    void create_success() {
        // given
        List<Player> players = generateRawPlayersByNames("pobi", "neo");

        // then
        assertThatNoException().isThrownBy(() -> new Players(players));
    }

    @DisplayName("Player가 두 명 미만일 경우 예외를 반환한다.")
    @Test
    void create_fail_by_not_enough_number_of_name() {
        // given
        List<Player> players = generateRawPlayersByNames("pobi");

        // then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 최소 2개 이상이여햡니다.");
    }

    @DisplayName("사람 이름이 중복되면 예외를 반환한다.")
    @Test
    void create_fail_by_duplicate_name() {
        // given
        List<Player> players = generateRawPlayersByNames("neo", "neo");

        // then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 중복 될 수 없습니다.");
    }

    @DisplayName("size()를 통해서 Player의 숫자를 정확하게 반환한다.")
    @Test
    void return_correct_size() {
        // given
        List<Player> rawPlayers = generateRawPlayersByNames("neo", "pobi", "jun");
        Players players = new Players(rawPlayers);

        //when
        int size = players.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    private List<Player> generateRawPlayersByNames(String... names) {
        return Arrays.stream(names)
                .map(Name::new)
                .map(Player::new)
                .collect(toList());
    }
}
