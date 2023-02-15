package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.Blocks;
import model.Names;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import strategy.FixedPassGenerator;

class BlockServiceTest {

    private final BlockService blockService = new BlockService(new FixedPassGenerator(false));

    @ParameterizedTest
    @CsvSource(value = {"4:3", "5:4"}, delimiter = ':')
    void initBlock_메소드는_입력_받은_사람_수_보다_1_적은_만큼의_BLOCK들을_생성하여_컬렉션으로_관리하는_BLOCKS를_반환한다(int peopleCount, int expected) {
        Blocks blocks = blockService.initBlocks(peopleCount);
        assertThat(blocks.getBlocks().size()).isSameAs(expected);
    }

    @Test
    void generateNames_메소드는_컬렉션_내의_이름_수만큼_NAME을_만들어_NAMES를_생성한다() {
        Names names = blockService.generateNames(List.of("pobi", "crong", "honux", "jk"));
        assertThat(names.getNames().size()).isSameAs(4);
    }
    @Test
    void 컬렉션_내_사람이름이_5글자_초과면_예외발생() {
        assertThatThrownBy(
            () -> blockService.generateNames(List.of("pobiaaa"))
        ).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("이름은 최대 5글자까지만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {""," ","   ","         "})
    void 컬렉션_내_사람이름이_공백이면_예외발생(String name) {
        assertThatThrownBy(
            () -> blockService.generateNames(List.of(name))
        ).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("이름은 공백일 수 없습니다.");
    }
}