/*
 * @(#)ResultTagsTest.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.tags;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class ResultTagsTest {
        /*사다리게임 결과 태그 그룹에 대한 테스트*/
        @Test
        void 플레이어수_결과수_일치_검사() {
                String[] input = {"aa", "bb"};
                assertThrows(IllegalArgumentException.class, () -> {
                        new ResultTags(input, 3);
                });
        }

        @Test
        void 인덱스로_태그_찾기_검사() {
                String[] input = {"aa", "bb", "cc", "dd"};
                assertThat(new ResultTags(input, 4).getTagByIndex(3)).isEqualTo(new Tag("dd"));
        }
}
