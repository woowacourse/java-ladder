package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static ladder.domain.Point.EMPTY;
import static ladder.domain.Point.FILLED;
import static org.assertj.core.api.Assertions.assertThat;

public class FloorTest {

    @Test
    @DisplayName("Floor에서 입력받은 리스트에 따라 points가 생성된다.")
    void makeFloorTest() {
        //given
        List<Point> list = new ArrayList<>(List.of(FILLED, EMPTY, FILLED));
        //when
        Floor floor = new Floor(list);
        //then
        assertThat(floor.getPoints())
                .containsExactly(FILLED, EMPTY, FILLED);
    }

    @Test
    @DisplayName("같은 층에서 Point.FILLED가 연속해서 생기지 않는다.")
    void makeNonContinuousLadderTest() {
        //given
        List<Point> list = new ArrayList<>(List.of(FILLED, FILLED, FILLED));
        //when
        Floor floor = new Floor(list);
        //then
        assertThat(floor.getPoints())
                .containsExactly(FILLED, EMPTY, FILLED);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:2", "3:4", "4:3"}, delimiter = ':')
    @DisplayName("양 옆 중 Point가 있는 곳으로 움직인다.")
    void moveVerticallyTest(int positionNow, int positionNext) {
        //given
        List<Point> list = new ArrayList<>(List.of(FILLED, EMPTY, EMPTY, FILLED));
        Floor floor = new Floor(list);

        //when
        var userPosition = floor.moveUserByPath(positionNow);

        //then
        assertThat(userPosition).isEqualTo(positionNext);
    }
}
