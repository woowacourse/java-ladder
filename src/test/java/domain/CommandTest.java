package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

    @DisplayName("1 ~ 5 글자가 아니면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "skdkds"})
    void createCommandFail(String input) {
        Assertions.assertThatThrownBy(() -> new Command(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("명령은 1 ~ 5 글자여야 합니다.");
    }

    @Test
    @DisplayName("all 을 생성한다.")
    void createAllCommandSuccess() {
        Command command = new Command("all");

        assertThat(command.isAllCommand()).isTrue();
    }

    @Test
    @DisplayName("player name 을 생성한다.")
    void createCommandSuccess() {
        Command command = new Command("play");

        assertThat(command.isCommandMatches(new Player("play", 0)))
                .isTrue();
    }

}
