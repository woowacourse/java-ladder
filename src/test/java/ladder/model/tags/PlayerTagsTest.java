/*
 * @(#)PlayerTagsTest.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.tags;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @version 1.0 2019년 05년 16일
 * @author 김효건
 */
public class PlayerTagsTest {
    /*사다리게임 플레이어 태그 그룹에 대한 테스트*/
    @Test
    void 중복_이름_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
           new PlayerTags("pobi,coogi,pobi,luffy");
        });
    }
    @Test
    void 입력형식_콤마시작_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new PlayerTags(",abc,abc");
        });
    }

    @Test
    void 입력형식_콤마끝_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new PlayerTags("abc,abc,");
        });
    }

    @Test
    void 입력형식_콤마중복_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new PlayerTags("abc,,abc");
        });
    }

    @Test
    void 입력형식_콤마만입력_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new PlayerTags(",");
        });
    }
}
