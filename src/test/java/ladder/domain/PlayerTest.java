package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @Test
    void 이름이_공백일_경우() {
        assertThatThrownBy(() -> new Player(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_빈값일_경우() {
        assertThatThrownBy(() -> new Player("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_null일_경우() {
        assertThatThrownBy(() -> new Player(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_5글자_초과일_경우() {
        assertThatThrownBy(() -> new Player("abcdefg")).isInstanceOf(IllegalArgumentException.class);
    }
}
