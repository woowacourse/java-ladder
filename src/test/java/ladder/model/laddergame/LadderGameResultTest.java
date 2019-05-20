package ladder.model.laddergame;

import ladder.model.laddergame.LadderGameResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderGameResultTest {

    @Test
    void Player_수와_다른_결과_수일_때_예외발생_검증() {
        assertThrows(IllegalArgumentException.class, () ->
                new LadderGameResult(Arrays.stream("꽝, 1000".split(",")).collect(Collectors.toList()), 5));
    }
}
