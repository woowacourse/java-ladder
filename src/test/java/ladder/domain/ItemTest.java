package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ItemTest {
    @Test
    public void 올바른_실행_결과가_입력됐을_때() {
        assertThatCode(() -> {
            new Item("꽝");
        }).doesNotThrowAnyException();
    }

    @Test
    public void 실행_결과에_공백이_입력됐을_때() {
        assertThatThrownBy(() -> {
            new Item("  ");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
