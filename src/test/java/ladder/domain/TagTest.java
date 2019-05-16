package ladder.domain;

import org.junit.jupiter.api.Test;

import ladder.domain.tag.Tag;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TagTest {
    @Test
    void 이름_길이_검사_0() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Tag("");
        });
    }

    @Test
    void 이름_길이_검사_5초과() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Tag("ABCDEF");
        });
    }

    @Test
    void 이름_공백포함_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Tag("ABC F");
        });
    }
}
