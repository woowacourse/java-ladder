package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayersTest {
    @Test
    void 플레이어이름들_콤마시작_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Players(",abc,abc");
        });
    }

    @Test
    void 플레이어이름들_콤마끝_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Players("abc,abc,");
        });
    }

    @Test
    void 플레이어이름들_콤마중복_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Players("abc,,abc");
        });
    }

    @Test
    void 플레이어이름들_콤마만입력_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Players(",");
        });
    }

    @Test
    void 플레이어이름들_중복_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
           new Players("aaa,aaa,bbb,ccc");
        });
    }
}
