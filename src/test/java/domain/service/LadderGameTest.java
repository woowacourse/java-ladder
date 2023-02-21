package domain.service;

import domain.vo.Height;
import domain.vo.Name;
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
        ladderGame.playLadderGame(List.of(new Name("test1"), new Name("test2"), new Name("test3")), ladderMaker.make(new Height(1), new Width(2)));
        assertThat(ladderGame.getPlayers().get(0).getPosition()).isEqualTo(1);
        assertThat(ladderGame.getPlayers().get(1).getPosition()).isEqualTo(0);
        assertThat(ladderGame.getPlayers().get(2).getPosition()).isEqualTo(2);
    }

}
