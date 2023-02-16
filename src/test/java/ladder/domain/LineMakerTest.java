package ladder.domain;

import ladder.domain.builder.BlockGenerator;
import ladder.domain.builder.LineMaker;
import ladder.domain.ladder.Block;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class LineMakerTest {

    @Test
    @DisplayName("라인에 연속해서 블록이 놓인다면 다시 블록을 놓는다.")
    void 올바른_라인이_생성되는지_테스트() {
        List<Block> blocks = newArrayList(Block.EXIST, Block.EXIST);
        BlockGenerator blockGenerator = new TestBlockGenerator(blocks);
        LineMaker lineMaker = new LineMaker(blockGenerator);
        int playerNumber = blocks.size() + 1;

        assertThat(lineMaker.makeLine(playerNumber).getBlocks())
                .isNotEqualTo(blocks);
    }

    @Test
    @DisplayName("<플레이어수 - 1>만큼의 블록이 생성된다.")
    void 올바른_개수의_블록이_생성되는지_확인() {
        List<Block> blocks = newArrayList(Block.EXIST);
        BlockGenerator blockGenerator = new TestBlockGenerator(new ArrayList<>(blocks));
        LineMaker lineMaker = new LineMaker(blockGenerator);
        int playerNumber = 2;

        assertThat(lineMaker.makeLine(playerNumber).getBlocks())
                .isEqualTo(blocks);
    }
}