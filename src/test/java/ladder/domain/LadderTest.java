package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.dto.BuiltLadderDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    private static final int FIRST_STEP_INDEX = 0;
    private static final int NEXT_STEP_INDEX = 1;
    private static final int NOT_BUILD_STEP_INDEX = 3;

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(5);
    }

    @Nested
    @DisplayName("이전 포지션에 스텝이 존재하는지 검사하는 테스트")
    class CheckDuplicateStepTest {

        @Test
        @DisplayName("이전 포지션에 스텝이 존재하면 True를 반환한다.")
        void hasDuplicatedStep() {
            ladder.buildSteps(FIRST_STEP_INDEX);

            Boolean hasDuplicateStep = ladder.hasStepDuplicated(NEXT_STEP_INDEX);

            assertThat(hasDuplicateStep).isTrue();
        }

        @Test
        @DisplayName("이전 포지션에 스텝이 존재하지 않으면 False를 반환한다.")
        void hasNotDuplicatedStep() {
            ladder.buildSteps(FIRST_STEP_INDEX);

            Boolean hasDuplicateStep = ladder.hasStepDuplicated(NOT_BUILD_STEP_INDEX);

            assertThat(hasDuplicateStep).isFalse();
        }
    }

    @Nested
    @DisplayName("스텝 건설 테스트")
    class MakeStepTest {

        @ParameterizedTest
        @ValueSource(ints = {2, 3, 4})
        @DisplayName("스텝을 건설한 구역은 True를 반환한다.")
        void successfullyMakeStepTest(int currentSector) {
            ladder.buildSteps(currentSector);

            BuiltLadderDto builtLadderDto = ladder.getSteps();
            assertThat(builtLadderDto.builtLadder().get(currentSector)).isEqualTo("-----");
        }
    }
}
