package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

    @DisplayName("입력 받은 커맨드가 all 커맨드인지 확인한다.")
    @Test
    void checkIsAllCommand() {
        String command = "all";

        boolean result = Command.isAllCommand(command);

        assertThat(result).isEqualTo(true);
    }
}
