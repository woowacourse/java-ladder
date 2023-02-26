package ladder.domain;

import ladder.domain.ladder.Block;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.generator.BlockGenerator;
import ladder.domain.player.PlayerName;
import ladder.domain.player.Players;
import ladder.domain.prize.Result;
import ladder.domain.prize.Results;
import ladder.domain.player.exception.NoSuchPlayerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    private LadderGame ladderGame;
    private Players players;
    private Results results;

    /**
     * pobi honux crong  jk
     * |-----|     |-----|
     * |     |-----|     |
     * |-----|     |     |
     * |     |-----|     |
     * |-----|     |-----|
     * 꽝   5000   꽝   3000
     */
    @BeforeEach
    void setup() {
        players = new Players(List.of("pobi", "honux", "crong", "jk"));
        results = new Results(players.size(), List.of("꽝", "5000", "꽝", "3000"));
        int playerNumber = players.size();
        int height = 5;
        Ladder ladder = setLadder(playerNumber, height);
        ladderGame = new LadderGame(players, results, ladder);
    }

    Ladder setLadder(int playerNumber, int height) {
        BlockGenerator blockGenerator = new TestBlockGenerator(
                List.of(Block.EXIST, Block.EXIST,
                        Block.EMPTY, Block.EXIST,
                        Block.EXIST, Block.EMPTY,
                        Block.EMPTY, Block.EXIST,
                        Block.EXIST, Block.EXIST));
        return new Ladder(blockGenerator, playerNumber, height);
    }

    @Test
    void 모든_플레이어의_결과가_정확한지_확인() {
        Map<PlayerName, Result> allResult = ladderGame.getAllResult();
        List<String> playerNames = allResult.keySet().stream()
                .map(playerName -> allResult.get(playerName).getName())
                .collect(Collectors.toUnmodifiableList());

        assertThat(playerNames).isEqualTo(List.of("꽝", "3000", "꽝", "5000"));
    }

    @Test
    void 플레이어_개별_조회_결과가_정확한지_확인() {
        PlayerName playerName = players.getPlayers().get(3);
        Result result = results.getPrizes().get(1);

        assertThat(ladderGame.getSinglePlayerResult(playerName)).isEqualTo(result);
    }

    @Test
    void 없는_플레이어_조회_시_예외_발생() {
        PlayerName playerName = new PlayerName("ditoo");

        assertThatThrownBy(() -> ladderGame.getSinglePlayerResult(playerName))
                .isInstanceOf(NoSuchPlayerException.class);
    }
}
