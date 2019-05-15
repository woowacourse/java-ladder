package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerNameTest {
    @Test
    void 이름_길이_검사_0() {
        assertThrows(IllegalArgumentException.class, ()->{
            PlayerName playerName = new PlayerName("");
        });
    }

    @Test
    void 이름_길이_검사_5초과() {
        assertThrows(IllegalArgumentException.class, ()->{
            PlayerName playerName = new PlayerName("ABCDEF");
        });
    }

    @Test
    void 이름_공백포함_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            PlayerName playerName = new PlayerName("ABC F");
        });
    }
}
