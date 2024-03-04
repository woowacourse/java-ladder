package ladder.domain;

import static ladder.domain.ladder.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Width;
import ladder.domain.player.Location;
import ladder.domain.player.Name;
import ladder.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @DisplayName("사다리를 입력하면 그 사다리를 탄 결과를 반환한다.")
    @Test
    void climbTest() {
        Player player = new Player(new Name("poby"), new Location(0));
        Ladder ladder = new Ladder(new Width(2), new Height(3), () -> RIGHT);

        Player expected = new Player(new Name("poby"), new Location(1));

        assertThat(player.climb(ladder)).isEqualTo(expected);
    }

    @DisplayName("이름만 같으면 equals는 true이다.")
    @Test
    void equalsTest() {
        Player poby0 = new Player(new Name("poby"), new Location(0));
        Player poby1 = new Player(new Name("poby"), new Location(1));
        Player honux0 = new Player(new Name("honux"), new Location(0));

        assertAll(
                () -> assertThat(poby0).isEqualTo(poby1),
                () -> assertThat(poby0).isNotEqualTo(honux0)
        );
    }
}
