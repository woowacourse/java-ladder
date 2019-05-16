package ladder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {
    @Test
    void 층수_입력형식_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
           new Floor("a");
        });
    }

    @Test
    void 층수_0이하_입력_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Floor("0");
        });
    }
}