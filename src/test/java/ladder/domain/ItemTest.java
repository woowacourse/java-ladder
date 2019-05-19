package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0 2019-05-18
 */
public class ItemTest {
    @Test
    void create_생성() {
        Item item = Item.newBuilder("abcde");
        assertThat(item).isEqualTo(Item.newBuilder(" abcde "));
    }

    @Test
    void create_이름_빈칸_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Item.newBuilder("");
        });
    }

    @Test
    void create_이름_스페이스_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Item.newBuilder(" ");
        });
    }

    @Test
    void create_이름_5자_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Item.newBuilder("aaaaaa");
        });
    }
}
