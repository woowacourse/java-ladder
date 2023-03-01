package ladder.domain;

import ladder.domain.ladderNode.Players;
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
}
