package ladder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {
    @Test
    void 플레이어수_결과수_일치검사() {
        assertThrows(IllegalArgumentException.class, ()->{
           new LadderGame(new Floor("5"),"AA,BB,CC","A,B");
        });
    }

    @Test
    void 결과출력할_플레이어_이름_존재_검사() {
        LadderGame ladderGame = new LadderGame(new Floor("5"),"aaa,bbb,ccc","aaa,bbb,ccc");
        assertThrows(IllegalArgumentException.class, ()->{
            ladderGame.getOnePlayerResult(new PlayerName("ddd"));
        });
    }

    @Test
    void 결과출력할_플레이어_이름_5자초과_검사() {
        LadderGame ladderGame = new LadderGame(new Floor("5"),"aaa,bbb,ccc","aaa,bbb,ccc");
        assertThrows(IllegalArgumentException.class, ()->{
            ladderGame.getOnePlayerResult(new PlayerName("dddddd"));
        });
    }
}