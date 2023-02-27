package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.LineTest.DeterminedBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    @Test
    @DisplayName("입력받은 높이에 따른 line을 생성한다")
    void shouldHasSizeOfInputWhenCreateLadder() {
        // given
        // when
        Ladder ladder = new Ladder(3, 4);
        //then
        assertThat(ladder.getLines()).hasSize(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:3", "2:0", "3:2"}, delimiter = ':')
    @DisplayName("위치를 입력 받아 사다리 모양에 맞게 이동시킨다.")
    void shouldMoveLocationByLadderWhenInputLocation() {
        // given
        List<Boolean> determinedBars = new ArrayList<>(List.of(
                false, true,
                true, true
        ));
        Ladder ladder = new Ladder(2, 3, new DeterminedBooleanGenerator(determinedBars));
        Location location = new Location(1);
        // when
        ladder.move(location);
        // then
        assertThat(location.getColumnIndex()).isEqualTo(3);
    }
}
