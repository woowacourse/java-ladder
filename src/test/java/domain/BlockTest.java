package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BlockTest {

    @Test
    void 앞의_block_건널_수_있으면_다음_block은_건널_수_없다() {
        Block preBlock = new Block(true);
        Block nextBlock = new Block(true);

        nextBlock.comparePreBlock(preBlock);

        Assertions.assertThat(nextBlock.getIsCross()).isFalse();
    }
}
