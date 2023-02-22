package ladder.domain;

import ladder.domain.ladder.Block;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.generator.BlockGenerator;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import ladder.domain.result.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ResultTest {

    private Result result;

    @BeforeEach
    void setup() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Prizes prizes = new Prizes(players.size(), List.of("꽝", "5000", "꽝", "3000"));
        int playerNumber = players.size();
        int height = 5;
        Ladder ladder = setLadder(playerNumber, height);
        result = new Result(players, prizes, ladder);
    }

    /**
     * |-----|     |-----|
     * |     |-----|     |
     * |-----|     |     |
     * |     |-----|     |
     * |-----|     |-----|
     */
    Ladder setLadder(int playerNumber, int height) {
        BlockGenerator blockGenerator = new TestBlockGenerator(
                List.of(Block.EXIST, Block.EXIST,
                        Block.EMPTY, Block.EXIST,
                        Block.EXIST, Block.EMPTY,
                        Block.EMPTY, Block.EXIST,
                        Block.EXIST, Block.EXIST));
        return new Ladder(blockGenerator, playerNumber, height);
    }
}
