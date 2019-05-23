/*
 * @(#)TagTest.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */
package ladder.model.tags;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
class TagTest {
        /*사다리게임 태그에 대한 테스트*/
        @Test
        void 길이_검사_0() {
                assertThrows(IllegalArgumentException.class, () -> {
                        new Tag("");
                });
        }

        @Test
        void 길이_검사_5초과() {
                assertThrows(IllegalArgumentException.class, () -> {
                        new Tag("ABCDEF");
                });
        }

        @Test
        void 공백포함_검사() {
                assertThrows(IllegalArgumentException.class, () -> {
                        new Tag("ABC F");
                });
        }

        @Test
        void 빈이름_검사() {
                assertThrows(IllegalArgumentException.class, () -> {
                        new Tag("");
                });
        }
}