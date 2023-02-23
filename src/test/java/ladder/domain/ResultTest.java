package ladder.domain;

import ladder.domain.ladder.Block;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.generator.BlockGenerator;
import ladder.domain.player.PlayerName;
import ladder.domain.player.Players;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.domain.result.Result;
import ladder.domain.result.exception.NoSuchPlayerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {

    private Result result;
    private Players players;
    private Prizes prizes;

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
        prizes = new Prizes(players.size(), List.of("꽝", "5000", "꽝", "3000"));
        int playerNumber = players.size();
        int height = 5;
        Ladder ladder = setLadder(playerNumber, height);
        result = new Result(players, prizes, ladder);
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
        Map<PlayerName, Prize> allResult = result.getAllResult();
        List<String> playerNames = allResult.keySet().stream()
                .map(playerName -> allResult.get(playerName).getName())
                .collect(Collectors.toUnmodifiableList());

        assertThat(playerNames).isEqualTo(List.of("꽝", "3000", "꽝", "5000"));
    }

    @Test
    void 플레이어_개별_조회_결과가_정확한지_확인() {
        PlayerName playerName = players.getPlayers().get(3);
        Prize prize = prizes.getPrizes().get(1);

        assertThat(result.getSinglePlayerResult(playerName)).isEqualTo(prize);
    }

    @Test
    void 없는_플레이어_조회_시_예외_발생() {
        PlayerName playerName = new PlayerName("ditoo");

        assertThatThrownBy(() -> result.getSinglePlayerResult(playerName))
                .isInstanceOf(NoSuchPlayerException.class);
    }
}
