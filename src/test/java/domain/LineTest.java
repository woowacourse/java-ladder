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
        @DisplayName(" 있는 디딤돌이면 지금 다리는 오른쪽으로 건널 수 있는 다리가 생성된다.")
        void givenCrossablePreviousFootstep_thenUncrossableCurrentFootStep() {
            Line line = new Line(new FixBooleanGenerator(true, true));

            line.generateStep();
            line.generateStep();
            line.generateStep();

            assertThat(line.isSteppableAt(2)).isTrue();
        }

        @ParameterizedTest(name = " 없는 디딤돌이면 지금 다리는 디딤돌이 생성되는 것이 허용된다.")
        @ValueSource(booleans = {true, false})
        void givenUnCrossablePreviousFootstep_thenNotUncrossableCurrentFootStep(boolean value) {
            Line line = new Line(new FixBooleanGenerator(false, value));

            line.generateStep();
            line.generateStep();

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
            line.generateStep();

            assertThat(line.isSteppableAt(0))
                    .isEqualTo(value);
        }
    }

    @Nested
    @DisplayName(" 한 step 이 연결되어 있다면, 왼쪽에서 오른쪽으로 연결된 정보만 보여준다.")
    class LineInformation{

        @Test
        void generateLineTest(){
            BooleanGenerator generator = new FixBooleanGenerator(true, false, true);

            Line line = new Line(generator);

            for(int generateCount = 0; generateCount<5; generateCount++){
                line.generateStep();
            }

            assertThat(line.getRightConnectionCondition()).containsExactly(true, false, false, true, false);
        }
    }
}
