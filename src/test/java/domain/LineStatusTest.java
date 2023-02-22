package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineStatusTest {

    @Test
    @DisplayName("true값을 입력하면 해당하는 다리가 존재하는 enum객체 생성")
    void existLineTest() {
        boolean isLine = true;
        assertThat(LineStatus.findBy(isLine)).isEqualTo(LineStatus.EXIST);
    }

    @Test
    @DisplayName("false값을 입력하면 해당하는 다리가 존재하지않는 enum객체 생성")
    void nonExistLineTest() {
        boolean isLine = false;
        assertThat(LineStatus.findBy(isLine)).isEqualTo(LineStatus.NON_EXIST);
    }
}
