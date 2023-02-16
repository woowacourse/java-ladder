package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @Test
    @DisplayName("이름 리스트를 받아 Player들을 생성한다.")
    void players_generatePairFromNames() {
        // expected
        List<String> names = List.of("dochi", "vero", "tori", "adfa");
        Players players = new Players(names);
        assertThat(players.getPlayerNames())
                .containsAll(names);
    }

    @Test
    @DisplayName("중복된 이름이 입력되면 예외를 던진다.")
    void players_throwExceptionDuplicatedNames() {
        // given
        List<String> duplicateNames = List.of("dochi", "dochi", "vero", "tori");

        // expected
        assertThatThrownBy(() -> new Players(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어가 없을 때 이름 최대 길이를 구하면 예외를 던진다.")
    void players_throwException_WhenPlayersAreEmpty() {
        // given
        Players players = new Players(List.of());

        // expected
        assertThatThrownBy(players::getNameMaxLength)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("플레이어들의 이름 최대 길이를 구한다.")
    void players_getMaxNameLength() {
        // given
        Players players = new Players(List.of("aaa", "bb", "c"));

        // expected
        assertThat(players.getNameMaxLength())
                .isEqualTo(3);
    }
}
