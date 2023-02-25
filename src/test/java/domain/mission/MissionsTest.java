package domain.mission;

import static org.assertj.core.api.Assertions.assertThat;

import domain.player.Position;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MissionsTest {

    @DisplayName("순서에 따른 미션을 반환할 수 있다.")
    @Test
    void findByPositionTest() {
        Missions missions = Missions.of(List.of("당첨", "꽝"), 2);
        Mission win = new Mission("당첨");
        Mission lose = new Mission("꽝");

        assertThat(missions.findByPosition(new Position(0))).isEqualTo(win);
        assertThat(missions.findByPosition(new Position(1))).isEqualTo(lose);
    }
}
