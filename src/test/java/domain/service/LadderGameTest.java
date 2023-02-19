package domain.service;

import domain.model.Ladder;
import domain.vo.Height;
import domain.vo.Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {
    @Test
    @DisplayName("사다리 게임 테스트")
    void playLadderGameTest(){
        LadderGame ladderGame = new LadderGame(2);
        PlayerMaker playerMaker =new PlayerMaker("test1,test2,test3");
        LadderMaker ladderMaker = new LadderMaker(()->true);
        ladderGame.playLadderGame(playerMaker.getPlayerList(),ladderMaker.make(new Height(1),new Width(2)));
        assertThat(playerMaker.getPlayerList().get(0).getPosition()).isEqualTo(1);
        assertThat(playerMaker.getPlayerList().get(1).getPosition()).isEqualTo(0);
        assertThat(playerMaker.getPlayerList().get(2).getPosition()).isEqualTo(2);
    }

}
