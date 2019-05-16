package ladder.model.frame;

import ladder.model.Results;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    @Test
    void 입력형식_콤마시작_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Input(",abc,abc");
        });
    }

    @Test
    void 입력형식_콤마끝_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Input("abc,abc,");
        });
    }

    @Test
    void 입력형식_콤마중복_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Input("abc,,abc");
        });
    }

    @Test
    void 입력형식_콤마만입력_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Input(",");
        });
    }
}