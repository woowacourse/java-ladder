/*
 * @(#)FloorTest.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
class FloorTest {
        /*사다리게임 층수에 대한 테스트*/
        @Test
        void 층수_입력형식_검사() {
                assertThrows(IllegalArgumentException.class, () -> {
                        new Floor("a");
                });
        }

        @Test
        void 층수_0이하_입력_검사() {
                assertThrows(IllegalArgumentException.class, () -> {
                        new Floor("0");
                });
        }
}