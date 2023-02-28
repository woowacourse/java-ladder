package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CommandTest {

    @DisplayName("명령어와 동일한 이름이 입력된 경우에는 true 값을 반환한다.")
    @Test
    void checkCommandName1() {
        List<String> names = List.of("kong", "odo", "gray", "kong", "all");
        Assertions.assertThat(Command.isIn(names)).isTrue();
    }

    @DisplayName("명령어와 동일한 이름이 입력되지 않은 경우에는 true 값을 반환한다.")
    @Test
    void checkCommandName2() {
        List<String> names = List.of("kong", "odo", "gray", "kong");
        Assertions.assertThat(Command.isIn(names)).isFalse();
    }
}
