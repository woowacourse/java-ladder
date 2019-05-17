package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    void 이름이_5글자_초과_일_때() {
        assertThatThrownBy(() -> new Player("pobipobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_null_일_경우() {
        assertThatThrownBy(() -> new Player(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_빈_값일_경우() {
        assertThatThrownBy(() -> new Player(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
