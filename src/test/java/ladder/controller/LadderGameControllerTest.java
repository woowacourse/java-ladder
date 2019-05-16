package ladder.controller;

import ladder.model.LadderGamePlayers;
import ladder.model.LadderGameResult;
import ladder.model.LadderPlayer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameControllerTest {

    @Test
    void 플레이어가_있는지_확인_테스트() {
        List<LadderPlayer> players = new ArrayList<>();
        players.add(new LadderPlayer("red"));
        players.add(new LadderPlayer("blue"));
        players.add(new LadderPlayer("green"));

        assertTrue(new LadderGamePlayers(players).existName("red"));
        assertFalse(new LadderGamePlayers(players).existName("black"));
    }

}