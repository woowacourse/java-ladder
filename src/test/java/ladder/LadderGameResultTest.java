package ladder;

import ladder.model.LadderGameResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderGameResultTest {

    @Test
    void Player_수와_다른_결과_수일_때_예외발생_검증(){
        assertThrows(IllegalArgumentException.class, ()->new LadderGameResult("꽝,5000,10000".split(","),5));
    }
}
