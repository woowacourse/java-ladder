package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    @Test
    void 참여자_생성() {
        Player player = new Player("a");
        assertThat(player).isEqualTo(new Player("a"));
    }

    @Test
    void 참여자_생성_이름_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            Player player = new Player("123456");
        });
    }

    @Test
    void 참여자_생성_이름_빈값인경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            Player player = new Player("");
        });
    }

    @Test
    void 참여자_생성_이름_스페이스인경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            Player player = new Player(" ");
        });
    }

    @Test
    void 참여자_생성_이름_null경우() {
        assertThrows(RuntimeException.class, () -> {
            Player player = new Player(null);
        });
    }
}
