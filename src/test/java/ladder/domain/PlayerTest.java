package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author heebg
 * @version 1.0 2019-05-16
 */
class PlayerTest {
    @Test
    void 참여자_생성() {
        Player player = new Player("a");
        assertThat(player).isEqualTo(new Player("a"));
    }

    @Test
    void 참여자_생성_이름_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("123456");
        });
    }

    @Test
    void 참여자_생성_이름_빈값인경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("");
        });
    }

    @Test
    void 참여자_생성_이름_스페이스인경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player(" ");
        });
    }

    @Test
    void 참여자_생성_이름_null경우() {
        assertThrows(RuntimeException.class, () -> {
            new Player(null);
        });
    }
}