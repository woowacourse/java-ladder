package ladder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTagsTest {
    @Test
    void 중복_이름_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
           new PlayerTags("pobi,coogi,pobi,luffy");
        });
    }
    @Test
    void 입력형식_콤마시작_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new PlayerTags(",abc,abc");
        });
    }

    @Test
    void 입력형식_콤마끝_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new PlayerTags("abc,abc,");
        });
    }

    @Test
    void 입력형식_콤마중복_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new PlayerTags("abc,,abc");
        });
    }

    @Test
    void 입력형식_콤마만입력_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new PlayerTags(",");
        });
    }
}
