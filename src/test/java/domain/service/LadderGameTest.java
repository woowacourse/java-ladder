package domain.service;

import domain.model.Player;
import domain.model.Players;
import domain.vo.Height;
import domain.vo.Name;
import domain.vo.Position;
import domain.vo.Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {
    @Test
    @DisplayName("사다리 게임 테스트")
    void playLadderGameTest() {
        LadderGame ladderGame = new LadderGame(2);
        LadderMaker ladderMaker = new LadderMaker(() -> true);
        Players players = new Players(List.of(new Player(new Name("test1"), new Position(0)),
                new Player(new Name("test2"), new Position(1)),
                new Player(new Name("test3"), new Position(2))));
        ladderGame.playLadderGame(players, ladderMaker.make(new Height(1), new Width(2)));
        assertThat(ladderGame.getPlayers().get(0).getPosition()).isEqualTo(1);
        assertThat(ladderGame.getPlayers().get(1).getPosition()).isEqualTo(0);
        assertThat(ladderGame.getPlayers().get(2).getPosition()).isEqualTo(2);
    }

}
