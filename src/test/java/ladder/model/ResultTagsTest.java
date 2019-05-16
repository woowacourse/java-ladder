package ladder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultTagsTest {
    @Test
    void 플레이어수_결과수_일치_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
           new ResultTags("aa,bb",3);
        });
    }

    @Test
    void 입력형식_콤마시작_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new ResultTags(",abc,abc",2);
        });
    }

    @Test
    void 입력형식_콤마끝_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new ResultTags("abc,abc,",2);
        });
    }

    @Test
    void 입력형식_콤마중복_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new ResultTags("abc,,abc",2);
        });
    }

    @Test
    void 입력형식_콤마만입력_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new ResultTags(",",1);
        });
    }
}
