package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RewardsTest {
    @Test
    void 상품의_개수는_2개_이상() {
        assertThrows(IllegalArgumentException.class, () ->
                new Rewards(Arrays.asList("pobi")));
    }
}