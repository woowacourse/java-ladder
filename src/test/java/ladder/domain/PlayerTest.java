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

    @Test
    void 참여자_위치_필드_추가() {
        Player player = new Player("abc", 1);
        assertThat(player).isEqualTo(new Player("abc", 1));
    }

    @Test
    void 참여자_위치_필드_추가_0_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("abv",-1);
        });
    }

    @Test
    void 참여자_포지션_왼쪽_변경() {
        Player player = new Player("abc", 1);
        player.moveLeftPosition();
        assertThat(player.getPosition()).isEqualTo(0);
    }

    @Test
    void 참여자_포지션_오른쪽_변경() {
        Player player = new Player("abc", 1);
        player.moveRightPosition();
        assertThat(player.getPosition()).isEqualTo(2);
    }
}
