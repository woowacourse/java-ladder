package ladder.domain;

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
        List<Boolean> blocks = newArrayList(true, true);
        BlockGenerator blockGenerator = new TestBlockGenerator(blocks);
        LineMaker lineMaker = new LineMaker(blockGenerator);
        int playerNumber = blocks.size() - 1;

        assertThat(lineMaker.makeLine(playerNumber).getBlocks())
                .isNotEqualTo(blocks);
    }
}