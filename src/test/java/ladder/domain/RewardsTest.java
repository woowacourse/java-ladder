package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RewardsTest {
    @Test
    void 사이즈0_체크() {
        Map<Integer, String> input = new HashMap<>();
        assertThrows(IllegalArgumentException.class,()->{
           new Rewards(input);
        });
    }
}
