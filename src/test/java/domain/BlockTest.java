package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BlockTest {

    @Test
    void 앞의_block이_건널_수_있으면_다음_block은_건널_수_없다() {
        //given
        Block preBlock = new Block(true);
        BooleanGenerator booleanGenerator = new BooleanGeneratorImplements();

        //when
        Block nextBlock = Block.createNextBlock(preBlock, booleanGenerator);

        //then
        Assertions.assertThat(nextBlock.getIsCross()).isFalse();
    }
}
