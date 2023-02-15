package service;

import static org.assertj.core.api.Assertions.assertThat;

import model.Blocks;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import strategy.FixedPassGenerator;

class BlockServiceTest {

    private final BlockService blockService = new BlockService(new FixedPassGenerator());

    @ParameterizedTest
    @CsvSource(value = {"4:3", "5:4"}, delimiter = ':')
    void initBlock_메소드는_입력_받은_사람_수_보다_1_적은_만큼의_BLOCK들을_생성하여_컬렉션으로_관리하는_BLOCKS를_반환한다(int peopleCount, int expected) {
        Blocks blocks = blockService.initBlocks(peopleCount);
        assertThat(blocks.getBlocks().size()).isSameAs(expected);
    }
}