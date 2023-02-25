package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.generator.BooleanGenerator;
import domain.generator.RandomBooleanGenerator;
import domain.ladder.Height;
import domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    private final BooleanGenerator randomLadderGenerator = new RandomBooleanGenerator();

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

    @Nested
    @DisplayName("라인 이동 테스트")
    class MoveLadderTest {
       /* @Test
        void 사다리를_따라_끝까지_이동한다() {
            BooleanGenerator trueBooleanGenerator = new TrueBooleanGenerator();
            Ladder nonRandomLadder = new Ladder(3, 3, trueBooleanGenerator);
            Assertions.assertEquals(nonRandomLadder.getExitPosition(0), 1);
            Assertions.assertEquals(nonRandomLadder.getExitPosition(1), 0);
            Assertions.assertEquals(nonRandomLadder.getExitPosition(2), 3);
            Assertions.assertEquals(nonRandomLadder.getExitPosition(3), 2);
        }*/
    }
}
