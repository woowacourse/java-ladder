package com.woowacourse.ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderControllerTest {

    @Test
    void testCreateLadderWithNullArgs() {
        assertThrows(NullPointerException.class, () -> {
            LadderController.createLadder(Arrays.asList("pobi", "crong"), null, 4);
        });
    }

    @Test
    void testCrateLadderWithNotEqualSizeLists() {
        assertThrows(IllegalArgumentException.class, () -> {
           LadderController.createLadder(Arrays.asList("pobi", "crong"), Arrays.asList("1", "2", "3"), 3);
        });
    }
}
