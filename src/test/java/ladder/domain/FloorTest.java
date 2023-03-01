package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class FloorTest {
    private final LineSource MAKE = LineSource.MAKE_LINE;
    private final LineSource BLANK = LineSource.MAKE_BLANK;

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
        List<LineSource> list = new ArrayList<>(List.of(MAKE, BLANK, MAKE));
        floor.makeFloor(list);
        assertThat(floor.getLines().get(0)).extracting("isExist").isEqualTo(true);
        assertThat(floor.getLines().get(1)).extracting("isExist").isEqualTo(false);
        assertThat(floor.getLines().get(2)).extracting("isExist").isEqualTo(true);
    }


    @Test
    @DisplayName("다리가 연속해서 생기지 않는 것을 테스트 한다")
    void makeNonContinuousLadderTest() {
        Floor floor = new Floor(3);
        List<LineSource> list = List.of(MAKE, MAKE, MAKE);
        floor.makeFloor(list);

        assertThat(floor.getLines().get(0)).extracting("isExist").isEqualTo(true);
        assertThat(floor.getLines().get(1)).extracting("isExist").isEqualTo(false);
        assertThat(floor.getLines().get(2)).extracting("isExist").isEqualTo(true);

    }

    @Test
    @DisplayName("Floor에 출발 위치를 입력하면 반환 위치를 반환한다.")
    void floorMoveTest() {
        final Floor floor = new Floor(2);
        floor.makeFloor(List.of(MAKE, MAKE));
        assertThat(floor.getResultPosition(2)).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4, 5, 6})
    @DisplayName("Floor의 크기에 맞지 않는 위치의 index값을 구하려 한다면 예외가 발생한다.")
    void resultPositionExceptionTest(int index) {
        final Floor floor = new Floor(3);
        assertThatThrownBy(() -> floor.getResultPosition(index))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 위치는 존재하지 않는 값입니다.");
    }

    @Test
    @DisplayName("Floor의 반환 결과 다중 테스트")
    void floorMoveMultipleTest() {
        final Floor floor = new Floor(2);
        floor.makeFloor(List.of(MAKE, MAKE));
        assertAll(
                () -> {
                    assertThat(floor.getResultPosition(0)).isEqualTo(1);
                },
                () -> {
                    assertThat(floor.getResultPosition(1)).isEqualTo(0);
                },
                () -> {
                    assertThat(floor.getResultPosition(2)).isEqualTo(2);
                }

        );
    }

    @Test
    @DisplayName("size 테스트")
    void floorSizeTest() {
        final Floor floor = new Floor(3);
        assertThat(floor.size()).isEqualTo(3);
    }

}
