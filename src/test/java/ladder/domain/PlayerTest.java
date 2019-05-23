package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @Test
    public void 올바른_이름이_입력됐을_때() {
        assertThatCode(() -> {
            new Player("cony");
        }).doesNotThrowAnyException();
    }

    @Test
    public void 이름에_공백이_들어갔을_때() {
        assertThatThrownBy(() -> {
            new Player("  ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 이름의_길이가_5를_초과할_때() {
        assertThatThrownBy(() -> {
            new Player("gooood");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
