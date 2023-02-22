package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerTest {

    @Test
    void 참가자는_이름을_가진다() {
        final Player player = new Player("name", Position.valueOf(1));

        assertThat(player.getName()).isEqualTo("name");
    }

    @Test
    void 참가자는_위치를_가진다() {
        final Player player = new Player("name", Position.valueOf(1));

        assertThat(player.getPosition()).isEqualTo(Position.valueOf(1));
    }
}
