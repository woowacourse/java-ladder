package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderTest {

    @DisplayName("사다리를 타고 내려갔을 때의 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,3", "1,1", "2,0", "3,2"})
    void shouldReturnResultOfLadder(int index, int expected) {
        LadderGenerator ladderGenerator = new LadderGenerator(
                new TestBooleanGenerator(
                        Lists.newArrayList(true, false, false, true, true, true, false, false, false)
                )
        );
        Ladder ladder = ladderGenerator.generateLadder(4, 4);
        assertThat(ladder.move(index)).isEqualTo(expected);
    }
}
