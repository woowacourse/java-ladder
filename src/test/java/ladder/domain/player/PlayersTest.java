package ladder.domain.player;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@DisplayNameGeneration(ReplaceUnderscores.class)
class PlayersTest {

    @Test
    void 생성시_플레이어의_수가_2미만이면_예외() {
        assertThatThrownBy(() -> new Players(of("a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 2명 이상이어야 합니다. 현재 : 1");
    }

}
