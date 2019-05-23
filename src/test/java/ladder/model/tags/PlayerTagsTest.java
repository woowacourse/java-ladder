/*
 * @(#)PlayerTagsTest.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.tags;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class PlayerTagsTest {
        /*사다리게임 플레이어 태그 그룹에 대한 테스트*/
        @Test
        void 중복_이름_검사() {
                String[] input = {"pobi", "coogi", "pobi", "luffy"};
                assertThrows(IllegalArgumentException.class, () -> {
                        new PlayerTags(input);
                });
        }

        @Test
        void 태그_수_추출_검사() {
                String[] input = {"pobi", "coogi", "jason", "luffy"};
                assertThat(new PlayerTags(input).getTagsNumber()).isEqualTo(4);
        }

        @Test
        void 태그이름으로_인덱스_찾기_검사() {
                String[] input = {"pobi", "coogi", "brown", "luffy", "cozi"};
                assertThat(new PlayerTags(input).getIndexByTag(new Tag("cozi"))).isEqualTo(4);
        }
}
