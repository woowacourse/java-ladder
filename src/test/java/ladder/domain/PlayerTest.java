package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@DisplayNameGeneration(ReplaceUnderscores.class)
class PlayerTest {

    @Test
    void 플레이어_생성() {
        assertDoesNotThrow(() -> new Player("pobi", 0));
    }

    @Test
    void 이름을_반환한다() {
        Player player = new Player("pobi", 0);
        assertThat(player.getName())
                .isEqualTo("pobi");
    }
}
