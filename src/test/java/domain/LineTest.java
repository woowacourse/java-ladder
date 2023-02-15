package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.BooleanGenerator;
import util.FixBooleanGenerator;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사다리 한 층은 ")
class LineTest {

    @Nested
    @DisplayName(" 이전 다리가 이전 다리가 건널 수")
    class GenerateFootsteps {
        @Test
        @DisplayName(" 있는 디딤돌이면 지금 다리는 디딤돌이 생성되는 것이 허용되지 않는다.")
        void givenCrossablePreviousFootstep_thenUncrossableCurrentFootStep() {
            Line line = new Line(new FixBooleanGenerator(true));

            line.generateFootStep();
            line.generateFootStep();

            assertThat(line.isSteppableAt(1)).isFalse();
        }

        @ParameterizedTest(name = " 없는 디딤돌이면 지금 다리는 디딤돌이 생성되는 것이 허용된다.")
        @ValueSource(booleans = {true, false})
        void givenUnCrossablePreviousFootstep_thenNotUncrossableCurrentFootStep(boolean value) {
            Line line = new Line(new FixBooleanGenerator(false, value));

            line.generateFootStep();
            line.generateFootStep();

            assertThat(line.isSteppableAt(1)).isEqualTo(value);
        }
    }

    @Nested
    @DisplayName(" 만약 특정 다리가")
    class SteepableInfomation {
        @ParameterizedTest(name = " {0}으면 {1}를 반환하다.")
        @CsvSource(value = {"있,true", "없,false"})
        void crossableFootStepCase(String condition, boolean value) {
            BooleanGenerator trueGenerator = new FixBooleanGenerator(value);

            Line line = new Line(trueGenerator);
            line.generateFootStep();

            assertThat(line.isSteppableAt(0))
                    .isEqualTo(value);
        }
    }
}