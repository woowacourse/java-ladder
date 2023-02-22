package domain;

import domain.mission.Mission;
import domain.mission.Missions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MissionsTest {

    @Test
    void 미션_index로_가져오기() {
        Mission mission1 = new Mission("당첨");
        Mission mission2 = new Mission("꽝");

        Missions missions = new Missions("당첨,꽝", 2);

        Assertions.assertThat(missions.getMissionByIndex(0)).isEqualTo(mission1);
        Assertions.assertThat(missions.getMissionByIndex(1)).isEqualTo(mission2);
    }
}
