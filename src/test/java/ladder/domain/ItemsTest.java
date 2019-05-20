package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ItemsTest {
    @Test
    public void 입력된_아이템에_빈칸이_있을_때() {
        assertThatThrownBy(() -> new Items(Arrays.asList("  ", "1000"), 2));
    }

    @Test
    public void 입력된_아이템의_수와_사람_수가_다를_때() {
        assertThatThrownBy(() -> new Items(Arrays.asList("1000", "꽝"), 3));
    }

    @Test
    public void getItemName() {
        Items items = new Items(Arrays.asList("1000", "꽝"), 2);

        assertThat(items.getItemName(0)).isEqualTo("1000");
        assertThat(items.getItemName(1)).isEqualTo("꽝");
    }
}
