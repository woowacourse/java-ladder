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
        String[] input = {"pobi","coogi","pobi","luffy"};
        assertThrows(IllegalArgumentException.class, ()->{
           new PlayerTags(input);
        });
    }
}
