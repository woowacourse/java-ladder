package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MembersTest {
    @Test
    void 중복되는_사람이_있을시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Members(Arrays.asList("pobi","pobi"));
        });
    }
}