package laddergame.command;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderCommandTest {

    @DisplayName("All 커맨드이면 True 이다.")
    @Test
    void isAllCommandTrue() {
        // given
        final String value = "all";

        // when
        final boolean allCommand = LadderCommand.isAllCommand(value);

        // then
        assertThat(allCommand).isTrue();
    }

    @DisplayName("All 커맨드가 아니면 False 이다.")
    @Test
    void isAllCommandFalse() {
        // given
        final String value = "alll";

        // when
        final boolean allCommand = LadderCommand.isAllCommand(value);

        // then
        assertThat(allCommand).isFalse();
    }
}
