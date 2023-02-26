package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandCountControllerTest {

    @Test
    @DisplayName("명령 횟수 제어기를 생성한다.")
    void createTestSuccess() {
        CommandCountController commandCountController = new CommandCountController();

        int count = commandCountController.getCount();

        assertThat(count).isEqualTo(0);
    }

}
