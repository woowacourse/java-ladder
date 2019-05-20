package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @Test
    public void 입력된_이름의_길이가_5가_넘을_때() {
        assertThatThrownBy(() -> new Player("aaaaaa")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력된_이름에_공백이_있을_때() {
        assertThatThrownBy(() -> new Player(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void isEqualName() {
        Player player = new Player("done");
        assertThat(player.isEqualName("done")).isTrue();
        assertThat(player.isEqualName("brown")).isFalse();
    }
}
