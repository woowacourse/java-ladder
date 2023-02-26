package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("이름과 위치를 입력받아 Player를 생성한다")
    void shouldCreatePlayerWhenInputNameAndPosition() {
        assertDoesNotThrow(() -> new Player("name", 0));
    }

    @Test
    @DisplayName("같은 이름을 입력하면 true를 반환한다")
    void shouldReturnTrueWhenInputEqualsName() {
        Player player = new Player("box", 0);

        boolean isMatch = player.isMatchesBy("box");

        assertThat(isMatch).isTrue();
    }

    @Test
    @DisplayName("player의 위치를 마지막까지 옮긴다")
    void shouldMoveResultPositionWhenExecute() {
        List<Boolean> determinedBars = new ArrayList<>(List.of(true, false, true));
        Ladder ladder = Ladder.generate(2, 2, new DeterminedBooleanGenerator(determinedBars));
        Player player = new Player("box", 0);

        player.move(ladder);

        assertThat(player.getPosition()).isEqualTo(2);
    }
}
