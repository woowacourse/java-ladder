package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerTest {

    @Test
    void throwExceptionWhenNameIsAll() {
        String name = "all";
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("all은 사용할 수 없는 이름입니다.");
    }

    @ParameterizedTest
    @CsvSource({"odo27", "kong"})
    void shouldReturnTrueWhenPlayerHasSameName(String playerName) {
        Player player = new Player(playerName);
        Name name = new Name(playerName);
        assertThat(player.hasSameName(name)).isTrue();
    }
}
