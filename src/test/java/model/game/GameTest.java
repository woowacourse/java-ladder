package model.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import model.bridge.Bridge;
import model.ladder.Ladder;
import model.ladder.LadderHeight;
import model.player.Player;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @DisplayName("모든 참여자에 대한 사다리 실행 결과를 얻는다")
    @Test
    void testGameResultIncludesAllPlayers() {
        Players players = Players.from(List.of("pobi", "lala"));
        LadderHeight ladderHeight = new LadderHeight(5);
        Ladder ladder = Ladder.of(ladderHeight, players, (count) -> createBridges(List.of(1)));
        Prizes prizes = Prizes.of(players, List.of("꽝", "3000"));
        Game game = new Game(ladder, players, prizes);

        GameResult gameResult = game.play();
        Map<Player, Prize> result = gameResult.getResult();

        assertThat(result.get(new Player("pobi")).getName())
                .isEqualTo("3000");
        assertThat(result.get(new Player("lala")).getName())
                .isEqualTo("꽝");
    }

    @DisplayName("한 참여자에 대한 사다리 실행 결과를 얻는다")
    @Test
    void testGameResultWithOnePlayer() {
        Players players = Players.from(List.of("pobi", "lala"));
        LadderHeight ladderHeight = new LadderHeight(5);
        Ladder ladder = Ladder.of(ladderHeight, players, (count) -> createBridges(List.of(1)));
        Prizes prizes = Prizes.of(players, List.of("꽝", "3000"));
        Game game = new Game(ladder, players, prizes);

        GameResult gameResult = game.play();
        Player targetPlayer = new Player("pobi");
        Prize targetPrize = gameResult.get(targetPlayer);

        assertThat(targetPrize.getName())
                .isEqualTo("3000");
    }

    private static List<Bridge> createBridges(List<Integer> codes) {
        return codes.stream()
                .map(code -> Bridge.findBridgeByCode(code).orElse(null))
                .toList();
    }
}
