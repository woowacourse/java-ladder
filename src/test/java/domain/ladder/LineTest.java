package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.BooleanGenerator;
import util.FixBooleanGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 한 층은 ")
class LineTest {

    @Nested
    @DisplayName("이전 다리가 오른쪽으로 뻗어 ")
    class GenerateFootsteps {
        @Test
        @DisplayName("있는 디딤돌이면 지금 다리는 완쪽으로 뻗었다는 정보를 담고 있다.")
        void givenPreviousFootstepConnected_thenConnectedCurrentStep() {
            Line line = Line.of(new FixBooleanGenerator(true));

            line.generateStep();
            line.generateStep();

            assertThat(line.isConnectedToRight(1)).isFalse();
        }

        @ParameterizedTest(name = "있지 않은 디딤돌이면 지금 다리는 오른쪽으로 연결되거나, 아무 쪽으로도 연결되지 않는다.")
        @ValueSource(booleans = {true, false})
        void givenPreviousFootstepUnConnected_thenRandomCurrentStep(boolean value) {
            Line line = Line.of(new FixBooleanGenerator(false, value));

            line.generateStep();
            line.generateStep();

            assertThat(line.isConnectedToRight(1)).isEqualTo(value);
        }
    }

    @ParameterizedTest(name = "특정 발판이 오른쪽으로 뻗어있는 지 여부를 반환하다.")
    @ValueSource(booleans = {false, true})
    void StepConnectedToRightCase(boolean value) {
        BooleanGenerator trueGenerator = new FixBooleanGenerator(value);
        Line line = Line.of(trueGenerator);
        line.generateStep();
        assertThat(line.isConnectedToRight(0))
                .isEqualTo(value);
    }
}