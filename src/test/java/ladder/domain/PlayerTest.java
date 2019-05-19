package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    @Test
    void 플레이어의_이름이_5자_이하일_때_정상적으로_생성되는지_테스트() {
        assertThat(new Player("qweas")).isEqualTo(new Player("qweas"));
    }

    @Test
    void 플레이어의_이름이_5자보다_클_때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player("qweasd"));
    }

    @Test
    void 플레이어의_이름이_공백으로만_이루어져_았을_때_얘외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player(" "));
    }

    @Test
    void 플레이어의_이름이_null일_때_얘외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player(null));
    }

    @Test
    void 플레이어의_이름이_all일_때_얘외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player("all"));
    }

}
