package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StepTest {

    @ParameterizedTest
    @DisplayName("발판 객체를 생성한다.")
    @ValueSource(booleans = {false, true})
    void createStep(boolean hasStep) {
        //give & when
        var step = new Step(hasStep);

//        //then
        Assertions.assertThat(step.hasStep()).isEqualTo(hasStep);
    }
}
