package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {
    @Test
    void 플레이어수_결과수_일치검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGame(new Players("AA,BB,CC"), new Results("A,B", 3), new Floor("5"));
        });
    }

    @Test
    void 결과출력할_플레이어_이름_존재_검사() {
        Players players = new Players("aaa,bbb,ccc");
        LadderGame ladderGame = new LadderGame(players, new Results("aaa,bbb,ccc", players.size()), new Floor("5"));
        assertThrows(IllegalArgumentException.class, () -> {
            ladderGame.getOnePlayerResult(new Name("ddd"));
        });
    }

    @Test
    void 결과출력할_플레이어_이름_5자초과_검사() {
        Players players = new Players("aaa,bbb,ccc");
        LadderGame ladderGame = new LadderGame(players, new Results("aaa,bbb,ccc", players.size()), new Floor("5"));
        assertThrows(IllegalArgumentException.class, () -> {
            ladderGame.getOnePlayerResult(new Name("dddddd"));
        });
    }
}