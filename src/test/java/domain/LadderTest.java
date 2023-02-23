package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.generator.BooleanGenerator;
import domain.generator.RandomBooleanGenerator;
import domain.generator.TrueBooleanGenerator;
import domain.ladder.Ladder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    private BooleanGenerator booleanGenerator = new RandomBooleanGenerator();

    @Nested
    @DisplayName("생성 테스트")
    class createLadderTest {
        @DisplayName("1이상 100이하 층 수를 테스트한다.")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 99, 100})
        void validFloorCountTest(int floorCount) {
            assertDoesNotThrow(() -> new Ladder(4, floorCount, booleanGenerator));
        }

        @DisplayName("1미만 100초과 층 수를 예외처리한다.")
        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 101, 102})
        void invalidFloorCountTest(int floorCount) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Ladder(4, floorCount, booleanGenerator));
        }
    }

    @Nested
    @DisplayName("라인 이동 테스트")
    class MoveLadderTest {
        @Test
        void 사다리를_따라_끝까지_이동한다() {
            BooleanGenerator trueBooleanGenerator = new TrueBooleanGenerator();
            Ladder nonRandomLadder = new Ladder(3, 3, trueBooleanGenerator);
            Assertions.assertEquals(nonRandomLadder.getExitPosition(0), 1);
            Assertions.assertEquals(nonRandomLadder.getExitPosition(1), 0);
            Assertions.assertEquals(nonRandomLadder.getExitPosition(2), 3);
            Assertions.assertEquals(nonRandomLadder.getExitPosition(3), 2);
        }
    }
}
