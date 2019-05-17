/*
 * @(#)LadderGameTest.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model;

import ladder.model.game.LadderGame;
import ladder.model.ladder.Floor;
import ladder.model.tags.PlayerTags;
import ladder.model.tags.ResultTags;
import ladder.model.tags.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @version 1.0 2019년 05년 16일
 * @author 김효건
 */
class LadderGameTest {
    /*사다리 게임을 진행에 대한 테스트*/
    @Test
    void 찾을_플레이어_존재_검사() {
        String[] inputPlayers = {"pobi","coogi","luffy"};
        String[] inputResults = {"1","2","3"};
        assertThrows(IllegalArgumentException.class, ()->{
            (new LadderGame(new PlayerTags(inputPlayers),new ResultTags(inputResults,3),new Floor("3")))
                    .getOneResultByTag(new Tag("jason"));
        });
    }
}