package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FloorTest {

    @Test
    @DisplayName("Floor에서 입력받은 리스트에 따라 points가 생성된다.")
    void makeFloorTest() {

        List<Boolean> list = new ArrayList<>(List.of(true, false, true));

        Floor floor = new Floor(list);


        assertThat(floor.getPoints())
                .containsExactly(true, false, true);
    }


    @Test
    @DisplayName("같은 층에서 Point.FILLED가 연속해서 생기지 않는다.")
    void makeNonContinuousLadderTest() {

        List<Boolean> list = new ArrayList<>(List.of(true, true, true));

        Floor floor = new Floor(list);


        assertThat(floor.getPoints())
                .containsExactly(true, false, true);
    }

}
