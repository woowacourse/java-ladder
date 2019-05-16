package ladder.model.frame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {
    @Test
    void 길이_검사_0() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Name("");
        });
    }

    @Test
    void 길이_검사_5초과() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Name("ABCDEF");
        });
    }

    @Test
    void 공백포함_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Name("ABC F");
        });
    }
}