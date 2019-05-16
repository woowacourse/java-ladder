package ladder.model.frame;

import ladder.model.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TagTest {
    @Test
    void 길이_검사_0() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Tag("");
        });
    }

    @Test
    void 길이_검사_5초과() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Tag("ABCDEF");
        });
    }

    @Test
    void 공백포함_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Tag("ABC F");
        });
    }
}