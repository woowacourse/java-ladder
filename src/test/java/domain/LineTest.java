package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.BooleanGenerator;
import util.FixBooleanGenerator;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사다리 한 층은 ")
class LineTest {

    @Nested
    class Generate {
        @Test
        @DisplayName(" 생성될 때 사람 수 만큼 다리를 생성한다.")
        void generateLine() {
            assertThatCode(() -> new Line(5))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName(" 사람이 다섯 명이라면 다리의 폭이 5다.")
        void givenFivePerson_thenWidthFive() {
            assertThat(new Line(5).getWidth())
                    .isEqualTo(5);
        }
    }

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
    class SteepableInfomation {
        @Test
        @DisplayName(" 만약 특정 다리가 건널 수 있으면 true를 반환하다.")
        void crossableFootStepCase() {
            BooleanGenerator trueGenerator = new FixBooleanGenerator(true);
            assertThat(new Line(5, trueGenerator).isSteppableAt(1))
                    .isTrue();
        }

        @Test
        @DisplayName(" 만약 특정 다리가 건널 수 없으면 false를 반환하다.")
        void uncrossableFootStepCase() {
            BooleanGenerator falseGenerator = new FixBooleanGenerator(false);
            assertThat(new Line(5, falseGenerator).isSteppableAt(1))
                    .isFalse();
        }
    }
}