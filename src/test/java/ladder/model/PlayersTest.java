package ladder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayersTest {
    @Test
    void 중복_이름_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
           new Players("pobi,coogi,pobi,luffy");
        });
    }
}
