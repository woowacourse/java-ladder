package domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerMakerTest {
    @Test
    @DisplayName("플레이어 입력 테스트")
    void makePlayersTest(){
        String input = "test1,test2,test3,test4,test5";
        PlayerMaker playerMaker = new PlayerMaker(input);
        for (int i = 0; i < 5; i++) {
            assertThat(playerMaker.getPlayerList().get(i).getName()).isEqualTo(String.format("test%d", i+1));
            assertThat(playerMaker.getPlayerList().get(i).getPosition()).isEqualTo(i);
        }
    }
}
