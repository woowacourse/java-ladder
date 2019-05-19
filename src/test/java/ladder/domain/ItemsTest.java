package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0 2019-05-18
 */
public class ItemsTest {
    @Test
    void create_생성() {
        Items items = Items.newBuilder("name,hi,name", 3);
        assertThat(items).isEqualTo(Items.newBuilder("name, hi, name", 3));
    }

    @Test
    void create_add_생성() {
        Items items = Items.newBuilder("name, hi, name", 3);
        assertThat(items).isEqualTo(Items.newBuilder("name,hi,name", 3));
    }

    @Test
    void create_개수_다름_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Items.newBuilder("name, hi, name", 4);
        });
    }

    @Test
    void iter_확인() {
        for (Item item : Items.newBuilder("name, pass, 1000", 3)) {
            System.out.println(item);
        }
    }
}
