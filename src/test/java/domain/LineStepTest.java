package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineStepTest {

    @Test
    @DisplayName("true값을 입력하면 해당하는 다리가 존재하는 enum객체 반환")
    void existLineTest() {
        boolean isLine = true;
        assertThat(LineStep.findBy(isLine)).isEqualTo(LineStep.EXIST);
    }

    @Test
    @DisplayName("false값을 입력하면 해당하는 다리가 존재하지않는 enum객체 반환")
    void nonExistLineTest() {
        boolean isLine = false;
        assertThat(LineStep.findBy(isLine)).isEqualTo(LineStep.NON_EXIST);
    }
}
