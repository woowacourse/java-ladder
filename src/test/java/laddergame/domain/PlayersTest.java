package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayersTest {
    @Test
    void 참가자의_수는_2명_이상() {
        assertThrows(IllegalArgumentException.class, () ->
                new Players(Arrays.asList("pobi")));
    }
    
    @Test
    void 중복된_이름은_불가능() {
        assertThrows(IllegalArgumentException.class, () ->
                new Players(Arrays.asList("pobi", "pobi")));
    }
}
