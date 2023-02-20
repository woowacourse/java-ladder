package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FloorTest {

    @Test
    @DisplayName("Floor에서 입력받은 리스트에 따라 points가 생성된다.")
    void makeFloorTest() {

        List<Point> list = new ArrayList<>(List.of(FILLED, EMPTY, FILLED));

        Floor floor = new Floor(list);

        assertThat(floor.getPoints())
                .containsExactly(FILLED, EMPTY, FILLED);
    }

    @Test
    @DisplayName("같은 층에서 Point.FILLED가 연속해서 생기지 않는다.")
    void makeNonContinuousLadderTest() {

        List<Point> list = new ArrayList<>(List.of(FILLED, FILLED, FILLED));

        Floor floor = new Floor(list);

        assertThat(floor.getPoints())
                .containsExactly(FILLED, EMPTY, FILLED);
    }

    @Test
    @DisplayName("양 옆에 다리가 있는 곳으로 움직인다.")
    void moveVerticallyTest() {
        //given
        List<Point> list = new ArrayList<>(List.of(FILLED, EMPTY, FILLED));
        Floor floor = new Floor(list);

        //when
        var userPosition = floor.moveUserByPath(0);

        //then
        assertThat(userPosition).isEqualTo(1);

    }

}
