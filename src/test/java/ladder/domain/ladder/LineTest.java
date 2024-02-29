package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.domain.dto.MadeLineDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LineTest {

    private static final int FIRST_STEP_INDEX = 0;
    private static final int NEXT_STEP_INDEX = 1;
    private static final int NOT_BUILD_STEP_INDEX = 3;

    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line(5);
    }

    @Nested
    @DisplayName("이전 포지션에 스텝이 존재하는지 검사하는 테스트")
    class CheckDuplicateStepTest {

        @DisplayName("이전 포지션에 스텝이 존재하면 True를 반환한다.")
        @Test
        void hasDuplicatedStep() {
            line.buildSteps(FIRST_STEP_INDEX);

            Boolean hasDuplicateStep = line.isStepDuplicatedWithBeforeStep(NEXT_STEP_INDEX);

            assertThat(hasDuplicateStep).isTrue();
        }

        @DisplayName("이전 포지션에 스텝이 존재하지 않으면 False를 반환한다.")
        @Test
        void hasNotDuplicatedStep() {
            line.buildSteps(FIRST_STEP_INDEX);

            Boolean hasDuplicateStep = line.isStepDuplicatedWithBeforeStep(NOT_BUILD_STEP_INDEX);

            assertThat(hasDuplicateStep).isFalse();
        }

        @DisplayName("build할 발판이 음수이거나 0일 경우 에러를 반환한다.")
        @Test
        void hasNotNegativePositionBuildStep() {
            assertThatThrownBy(() -> line.isStepDuplicatedWithBeforeStep(-1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복 확인 발판의 위치는 음수일 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("스텝 건설 테스트")
    class MakeStepTest {

        @ParameterizedTest
        @ValueSource(ints = {2, 3, 4})
        @DisplayName("스텝을 건설한 구역은 True를 반환한다.")
        void successfullyMakeStepTest(int currentSector) {
            line.buildSteps(currentSector);

            MadeLineDto madeLine = line.getSteps();
            Assertions.assertThat(madeLine.line().get(currentSector).getBuildStatus()).isEqualTo(true);
        }
    }
}
