package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0 2019-05-17
 */
public class PlayerTest {
    @Test
    void create_생성() {
        Player player = Player.newInstance("namea");
        assertThat(Player.newInstance("namea")).isEqualTo(player);
    }

    @Test
    void create_이름_공백_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Player.newInstance("");
        });
    }

    @Test
    void create_이름_글자수_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Player.newInstance("aaaaaa");
        });
    }

    @Test
    void create_공백_삭제되는지_확인() {
        Player player = Player.newInstance(" name ");
        assertThat(Player.newInstance("name")).isEqualTo(player);
    }

    @Test
    void create_이름_all_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Player.newInstance("all");
        });
    }
}
