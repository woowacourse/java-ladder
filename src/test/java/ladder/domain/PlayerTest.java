package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @DisplayName("사다리를 입력하면 그 사다리를 탄 결과를 반환한다.")
    @Test
    void climbTest() {
        Player poby = new Player(new Name("poby"), new Location(0));
        Player honux = new Player(new Name("honux"), new Location(1));
        Ladder ladder = new Ladder(new Width(2), new Height(3), () -> RIGHT);

        Player expectedPoby = new Player(new Name("poby"), new Location(1));
        Player expectedHonux = new Player(new Name("honux"), new Location(0));

        assertAll(
                () -> assertThat(poby.climb(ladder)).isEqualTo(expectedPoby),
                () -> assertThat(honux.climb(ladder)).isEqualTo(expectedHonux)
        );
    }

    @DisplayName("이름만 같으면 equals는 true이다.")
    @Test
    void equalsTest() {
        Player poby0 = new Player(new Name("poby"), new Location(0));
        Player poby1 = new Player(new Name("poby"), new Location(1));
        Player honux0 = new Player(new Name("honux"), new Location(0));
        Player honux1 = new Player(new Name("honux"), new Location(1));

        assertAll(
                () -> assertThat(poby0).isEqualTo(poby1),
                () -> assertThat(poby0).isNotEqualTo(honux0),
                () -> assertThat(poby0).isNotEqualTo(honux1)
        );
    }
}
