package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameTest {
    @Test
    void 이름_길이_검사_0() {
        assertThrows(IllegalArgumentException.class, ()->{
            Name name = new Name("");
        });
    }

    @Test
    void 이름_길이_검사_5초과() {
        assertThrows(IllegalArgumentException.class, ()->{
            Name name = new Name("ABCDEF");
        });
    }

    @Test
    void 이름_공백포함_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            Name name = new Name("ABC F");
        });
    }
}
