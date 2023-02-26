package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("명령을 20번 수행하면 종료된다.")
    void isExhaustedSuccess() {
        Command command = new Command("test");
        CommandCountController commandCountController = new CommandCountController();

        for (int i = 0; i < 20; i++) {
            commandCountController.execute(command);
        }

        assertThat(commandCountController.isExhausted()).isTrue();
    }

    @Test
    @DisplayName("명령 횟수가 20번을 초과하면 예외가 발생한다.")
    void executeFail() {
        Command command = new Command("test");
        CommandCountController commandCountController = new CommandCountController();

        for (int i = 0; i < 20; i++) {
            commandCountController.execute(command);
        }

        assertThatThrownBy(() -> commandCountController.execute(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과 조회는 더 이상 불가합니다.");
    }

    @Test
    @DisplayName("명령 입력이 all 이면 횟수를 20으로 설정하여 종료한다.")
    void isAllCommandSuccess() {
        Command command = new Command("all");
        CommandCountController commandCountController = new CommandCountController();

        commandCountController.execute(command);
        int count = commandCountController.getCount();

        assertThat(count).isEqualTo(20);
        assertThat(commandCountController.isExhausted()).isTrue();
    }

}
