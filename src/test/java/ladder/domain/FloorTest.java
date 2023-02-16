package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FloorTest {

    @Test
    @DisplayName("사이즈를 입력 받는 층 생성 테스트")
    void makeFloorBySIze() {
        Floor floor = new Floor(3);
        assertThat(floor.getLines().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Floor에 있는 라인 전부에게 생성 명령 테스트")
    void makeFloorTest() {
        Floor floor = new Floor(3);
        List<Integer> list = new ArrayList<>(List.of(1, 0, 1));
        floor.makeFloor(list);
        assertThat(floor.getLines().get(0)).extracting("isExist").isEqualTo(true);
        assertThat(floor.getLines().get(1)).extracting("isExist").isEqualTo(false);
        assertThat(floor.getLines().get(2)).extracting("isExist").isEqualTo(true);
    }


    @Test
    @DisplayName("다리가 연속해서 생기지 않는 것을 테스트 한다")
    void makeNonContinuousLadderTest() {
        Floor floor = new Floor(3);
        List<Integer> list = new ArrayList<>(List.of(1, 1, 1));
        floor.makeFloor(list);

        assertThat(floor.getLines().get(0)).extracting("isExist").isEqualTo(true);
        assertThat(floor.getLines().get(1)).extracting("isExist").isEqualTo(false);
        assertThat(floor.getLines().get(2)).extracting("isExist").isEqualTo(true);

    }

}
