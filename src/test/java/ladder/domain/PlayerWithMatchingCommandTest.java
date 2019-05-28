package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerWithMatchingCommandTest {

    @Test
    void isFinished_참() {
        PlayerWithMatchingCommand result = PlayerWithMatchingCommand.of(Player.from("hello"), MatchingCommand.FINISHED);

        assertThat(result.isFinished()).isTrue();
    }

    @Test
    void isFinished_거짓() {
        PlayerWithMatchingCommand result = PlayerWithMatchingCommand.of(Player.from("hello"), MatchingCommand.GOING);

        assertThat(result.isFinished()).isFalse();
    }
}