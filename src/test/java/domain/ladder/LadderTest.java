package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.generator.LadderStepGenerator;
import domain.generator.RandomLadderStepGenerator;
import domain.generator.ExistsLadderStepGenerator;
import domain.player.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    private final LadderStepGenerator randomLadderGenerator = new RandomLadderStepGenerator();
    private final LadderStepGenerator nonRandomLadderGenerator = new ExistsLadderStepGenerator();

    @DisplayName("유효한 파라미터가 들어오면, 사다리를 생성한다.")
    @Nested
    class createLadderTest {
        @DisplayName("사다리는 세로로 1칸 이상 100칸 이하인 경우 정상 생성된다.")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 99, 100})
        void validFloorCountTest(int count) {
            assertDoesNotThrow(() -> new Ladder(4, new Height(count), randomLadderGenerator));
        }

        @DisplayName("세로로 1칸 미만이거나 100칸을 초과하는 경우 사다리를 생성할 수 없다.")
        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 101, 102})
        void invalidFloorCountTest(int count) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Ladder(4, new Height(count), randomLadderGenerator));
        }
    }


    @DisplayName("초기 위치에 따라 도착하는 최종 위치를 알려줄 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "0,1",
            "1,0",
            "2,3",
            "3,2"}
    )
    void findFinalPositionTest(int initialIndex, int finalIndex) {
        Ladder ladder = new Ladder(3, new Height(3), nonRandomLadderGenerator);
            /*
              |-----|     |-----|
              |-----|     |-----|
              |-----|     |-----|
            */
        assertThat(ladder.findFinalPosition(new Position(initialIndex))).isEqualTo(new Position(finalIndex));
    }
}
