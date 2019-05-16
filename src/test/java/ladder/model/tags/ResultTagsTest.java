/*
 * @(#)ResultTagsTest.java      1.0 2019/05/16
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
public class ResultTagsTest {
    /*사다리게임 결과 태그 그룹에 대한 테스트*/
    @Test
    void 플레이어수_결과수_일치_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
           new ResultTags("aa,bb",3);
        });
    }

    @Test
    void 입력형식_콤마시작_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new ResultTags(",abc,abc",2);
        });
    }

    @Test
    void 입력형식_콤마끝_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new ResultTags("abc,abc,",2);
        });
    }

    @Test
    void 입력형식_콤마중복_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new ResultTags("abc,,abc",2);
        });
    }

    @Test
    void 입력형식_콤마만입력_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new ResultTags(",",1);
        });
    }
}
