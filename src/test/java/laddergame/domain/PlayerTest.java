package laddergame.domain;

import laddergame.domain.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    @Test
    public void 이름_객체_생성_검사() {
        Player name = new Player("pobi");
        assertThat(name).isEqualTo(new Player("pobi"));
        assertThat(name).isNotEqualTo(new Player("red"));
    }

    @Test
    public void 이름의_길이가_5자_초과일때_예외_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("monito");
        });
    }

    @Test
    public void 이름이_공백일때() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player(" ");
            new Player("");
            new Player(null);
        });
    }
}
