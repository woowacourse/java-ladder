package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandCountControllerTest {

    @Test
    @DisplayName("명령 횟수 제어기를 생성한다.")
    void createCommandCountControllerSuccess() {
        CommandCountController commandCountController = new CommandCountController();

        int count = commandCountController.getCount();

        assertThat(count).isEqualTo(0);
    }
    
    @DisplayName("명령이 들어오면 count가 상승한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void executeCommandSuccess(int numberOfExecute) {
        Command command = new Command("test");
        CommandCountController commandCountController = new CommandCountController();

        for (int i = 0; i < numberOfExecute ; i++) {
            commandCountController.execute(command);
        }
        int count = commandCountController.getCount();

        assertThat(count).isEqualTo(numberOfExecute);
    }

}
