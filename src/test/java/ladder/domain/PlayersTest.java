package ladder.domain;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters"})
@DisplayNameGeneration(ReplaceUnderscores.class)
class PlayersTest {

    @Test
    void 생성시_플레이어의_수가_2미만이면_예외() {
        assertThatThrownBy(() -> new Players(of("a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 2명 이상이어야 합니다. 현재 : 1");
    }

    @Test
    void 플레이어들의_이름을_반환한다() {
        Players players = new Players(of("a", "b", "c"));
        assertThat(players.getPlayerNames())
                .isEqualTo(of("a", "b", "c"));
    }
}
