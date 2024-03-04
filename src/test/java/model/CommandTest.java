package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandTest {

    @Test
    @DisplayName("지정된 문자열이 아닌 문자를 입력하면 따른 Command.NAME를 반환한다.")
    void findNameCommandTest() {
        Command command = Command.inputTextToCommand("name");
        assertThat(command).isEqualTo(Command.NAME);
    }

    @Test
    @DisplayName("exit 문자열을 입력하면 Command.EXIT을 반환한다.")
    void findExitCommandTest() {
        Command command = Command.inputTextToCommand("exit");
        assertThat(command).isEqualTo(Command.EXIT);
    }

    @Test
    @DisplayName("all문자열을 입력하면 Command.ALL을 반환한다.")
    void findAllCommandTest() {
        Command command = Command.inputTextToCommand("all");
        assertThat(command).isEqualTo(Command.ALL);
    }
}
