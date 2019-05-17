package ladder.domain;

import org.junit.jupiter.api.Test;

import ladder.domain.ladder.Height;
import ladder.domain.tag.Tag;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {
    @Test
    void 플레이어수_결과수_일치검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGame(new PlayerTags("AA,BB,CC"), new ResultTags("A,B", 3), new Height("5"));
        });
    }

    @Test
    void 결과출력할_플레이어_이름_존재_검사() {
        PlayerTags playerTags = new PlayerTags("aaa,bbb,ccc");
        LadderGame ladderGame = new LadderGame(playerTags, new ResultTags("aaa,bbb,ccc", playerTags.size()), new Height("5"));
        assertThrows(IllegalArgumentException.class, () -> {
            ladderGame.getOnePlayerResult(new Tag("ddd"));
        });
    }

    @Test
    void 결과출력할_플레이어_이름_5자초과_검사() {
        PlayerTags playerTags = new PlayerTags("aaa,bbb,ccc");
        LadderGame ladderGame = new LadderGame(playerTags, new ResultTags("aaa,bbb,ccc", playerTags.size()), new Height("5"));
        assertThrows(IllegalArgumentException.class, () -> {
            ladderGame.getOnePlayerResult(new Tag("dddddd"));
        });
    }
}