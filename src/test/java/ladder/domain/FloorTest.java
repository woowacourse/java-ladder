package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class FloorTest {

    @Test
    @DisplayName("Floor가 생성자에서 받은 value의 크기를 가진 lines를 생성한다.")
    void makeFloorBySize() {
        Floor floor = new Floor(3);

        assertThat(floor.getLines().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Floor에서 입력받은 숫자에 따라 line이 생성된다.")
    void makeFloorTest() {

        Floor floor = new Floor(3);

        List<Boolean> list = new ArrayList<>(List.of(true, false, true));
        floor.makeFloor(list);

        assertThat(floor.getLines())
                .containsExactly(true, false, true);
    }


    @Test
    @DisplayName("같은 층에서 Line이 연속해서 생기지 않는다.")
    void makeNonContinuousLadderTest() {
        Floor floor = new Floor(3);

        List<Boolean> list = new ArrayList<>(List.of(true, true, true));
        floor.makeFloor(list);

        assertThat(floor.getLines())
                .containsExactly(true, false, true);
    }

}
