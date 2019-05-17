package ladder.domain;

import org.junit.jupiter.api.Test;

import ladder.domain.ladder.Height;

import static org.junit.jupiter.api.Assertions.*;

class HeightTest {
    @Test
    void 층수_입력형식_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
           new Height("a");
        });
    }

    @Test
    void 층수_0이하_입력_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Height("0");
        });
    }
}