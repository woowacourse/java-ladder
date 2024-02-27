package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StickTest {

    static final Player LEFT = new Player("pobi");
    static final Player RIGHT = new Player("jk");

    @DisplayName("막대가 해당 자리에 있을 경우, 두 플레이어 위치를 바꾼다")
    @Test
    void progressSwitchingTest_WhenIsExist() {
        Stick stick = Stick.EXISTENCE;

        List<Player> actual = stick.progressSwitching(LEFT, RIGHT);

        assertThat(actual).containsExactly(RIGHT, LEFT);
    }

    @DisplayName("막대가 해당 자리에 있을 경우, 두 플레이어 위치가 그대로이다")
    @Test
    void progressSwitchingTest_WhenIsNotExist() {
        Stick stick = Stick.NON_EXISTENCE;

        List<Player> actual = stick.progressSwitching(LEFT, RIGHT);

        assertThat(actual).containsExactly(LEFT, RIGHT);
    }

    @DisplayName("막대가 해당자리에 있는지 테스트")
    @Test
    void isExistTest() {

        assertThat(Stick.EXISTENCE.isExist()).isTrue();
    }

    @DisplayName("막대가 해당자리에 없는지 테스트")
    @Test
    void isNonExistTest() {

        assertThat(Stick.NON_EXISTENCE.isExist()).isFalse();
    }
}
