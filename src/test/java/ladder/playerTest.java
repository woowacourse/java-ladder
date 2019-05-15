package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class playerTest {

    @Test
    void 이름의_길이_5이하_테스트() {
        Player player = new Player("aaaaa");
        assertThat(player.getName().length()).isEqualTo(5);
    }

    @Test
    void 이름의_길이_공백_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player(""));
    }

    @Test
    void 이름의_길이_6이상_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player("aaaaaa"));
    }
}
