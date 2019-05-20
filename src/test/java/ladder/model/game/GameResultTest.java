/*
 * @(#)GameResultTest.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.game;

import ladder.model.tags.Tag;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @version 1.0 2019년 05년 16일
 * @author 김효건
 */
class GameResultTest {
    /*게임결과 테스트에 관한 클래스*/
    @Test
    void 결과_추출_검사() {
        GameResult gameResult = new GameResult();

        Tag inTag1 = new Tag("a");
        Tag inTag2 = new Tag("b");
        Tag inTag3 = new Tag("c");

        Tag outTag1 = new Tag("1");
        Tag outTag2 = new Tag("2");
        Tag outTag3 = new Tag("3");


        gameResult.addResult(inTag1, outTag1);
        gameResult.addResult(inTag2, outTag2);
        gameResult.addResult(inTag3, outTag3);

        Map<Tag, Tag> result = new LinkedHashMap();
        result.put(inTag1,outTag1);
        result.put(inTag2,outTag2);
        result.put(inTag3,outTag3);

        assertThat(gameResult.getMappingResult()).isEqualTo(result);
    }
}