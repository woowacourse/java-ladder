package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @Test
    void 이름이_5글자_초과_일_때() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("pobipobi");
        });
    }
}
