package domain;

import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.player.Names;
import domain.player.Players;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.FixBooleanGenerator;

@DisplayName("사다리 게임은 ")
class LadderGameTest {

    @Test
    @DisplayName(" 생성시 사다리, 플레이어 목록, 상품 목록을 받아 생성된다.")
    void generateLadderGameCase() {
        //given
        Players players = new Players(new Names(List.of("pobi", "crong", "bkcat")));
        Prizes prizes = new Prizes(List.of("3000", "4000", "5000"));
        Ladder ladder = new LadderGenerator(new FixBooleanGenerator(true, true, false,
                                                                                true, true, false)).build(2,3);

        //then
        Assertions.assertDoesNotThrow(()->new LadderGame(ladder, players, prizes));
    }
}
