package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.BooleanGenerator;
import util.FixBooleanGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 한 층은 ")
class LineTest {

    @Nested
    @DisplayName("이전 다리가 오른쪽으로 연결되어 ")
    class GenerateFootsteps {
        @Test
        @DisplayName("있으면 지금 다리는 완쪽으로 연결되었다는 정보를 담고 있다.")
        void givenPreviousFootstepConnected_thenConnectedCurrentStep() {
            Line line = Line.of(2, new FixBooleanGenerator(true));

            line.generateSteps();

            assertThat(line.isConnectedToLeft(1)).isTrue();
        }

        @ParameterizedTest(name = "있지 않으면 지금 다리는 오른쪽으로 연결되거나, 아무 쪽으로도 연결되지 않는다.")
        @CsvSource(value = {"false,false,false", "true, false, true"})
        void givenPreviousFootstepUnConnected_thenRandomCurrentStep(boolean isConnectedToRight, boolean left, boolean right) {
            Line line = Line.of(3, new FixBooleanGenerator(false, isConnectedToRight, false));

            line.generateSteps();

            assertThat(line.isConnectedToLeft(1)).isEqualTo(left);
            assertThat(line.isConnectedToRight(1)).isEqualTo(right);
        }

        @Test
        @DisplayName("있고, 현재 발판이 마지막 발판이면 완쪽으로 연결되었다는 정보를 담는다.")
        void givenLastStepPreviousConnected_thenConnectedCurrentStep() {
            Line line = Line.of(2, new FixBooleanGenerator(true));

            line.generateSteps();

            assertThat(line.isConnectedToLeft(1)).isTrue();
        }

        @Test
        @DisplayName("있지 않고, 현재 발판이 마지막 발판이면 아무 곳에도 연결되지 않았다는 정보를 담는다.")
        void givenLastStepPreviousUnConnected_thenUnConnectedCurrentStep() {
            Line line = Line.of(2, new FixBooleanGenerator(false));

            line.generateSteps();

            assertThat(line.isConnectedToLeft(1)).isFalse();
            assertThat(line.isConnectedToRight(1)).isFalse();
        }
    }

    @ParameterizedTest(name = "특정 발판이 오른쪽으로 뻗어있는 지 여부를 반환하다.")
    @ValueSource(booleans = {false, true})
    void StepConnectedToRightCase(boolean value) {
        BooleanGenerator generator = new FixBooleanGenerator(value, false);
        Line line = Line.of(2, generator);
        line.generateSteps();
        assertThat(line.isConnectedToRight(0))
                .isEqualTo(value);
    }
}