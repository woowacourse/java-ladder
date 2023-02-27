package domain.mission;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MissionsTest {

    @DisplayName("정상 입력값을 통해 미션을 생성할 수 있다.")
    @Test
    void createMissionsTest() {
        Missions missions = Missions.createWithSize(List.of("당첨", "꽝", "3000원"), 3);

        Mission mission1 = new Mission("당첨");
        Mission mission2 = new Mission("꽝");
        Mission mission3 = new Mission("3000원");

        assertThat(missions.getMissions()).contains(mission1, mission2, mission3);
    }
}
