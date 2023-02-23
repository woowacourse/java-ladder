package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
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
        Ladder ladder = Ladder.generate(3, 4, new RandomBooleanGenerator());
        //then
        assertThat(ladder.getLines()).hasSize(3);
    }

    /*
    |---|   |
    |   |---|
    */
    @ParameterizedTest
    @CsvSource(value = {"0:2", "1:0", "2:1"}, delimiter = ':')
    @DisplayName("출발 위치에 따라 결과를 반환한다")
    void shouldReturnResultPositionWhenMoveLadder(int startPosition, int expectPosition) {
        List<Boolean> determinedBars = new ArrayList<>(List.of(true, false, true));
        Ladder ladder = Ladder.generate(2, 2, new DeterminedBooleanGenerator(determinedBars));
        Position position = new Position(startPosition);

        ladder.moveToResult(position);

        assertThat(position).isEqualTo(new Position(expectPosition));
    }
}
