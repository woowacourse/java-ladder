package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerTest {

    @Test
    void 참가자가_정상적으로_생성된다() {
        final Player player = new Player("name", Position.valueOf(0));

        assertThat(player.getName()).isEqualTo("name");
    }

    @Test
    void 참가자는_위치를_가진다() {
        final Player player = new Player("name", Position.valueOf(0));

        assertThat(player.getPosition()).isEqualTo(Position.valueOf(0));
    }
}
