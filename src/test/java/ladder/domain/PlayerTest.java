package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    @Test
    void 정상_입력() {
        Player player = new Player("pobi");
        assertThat(player).isEqualTo(new Player("pobi"));
    }

    @Test
    void 공백이_처음과끝_입력() {
        Player player = new Player(" pobi  ");
        assertThat(player).isEqualTo(new Player("pobi"));
    }

    @Test
    void 이름길이_초과_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("666666");
        });
    }

    @Test
    void NULL_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player(null);
        });
    }

    @Test
    void 공백_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("");
        });
    }

    @Test
    void 이름_all_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("all");
        });
    }
}

