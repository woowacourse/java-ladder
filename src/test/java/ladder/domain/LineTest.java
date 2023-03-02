package ladder.domain;

import ladder.domain.ladder.Block;
import ladder.domain.ladder.generator.BlockGenerator;
import ladder.domain.ladder.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LineTest {

    @Test
    @DisplayName("라인에 연속해서 블록이 놓인다면 다시 블록을 놓는다.")
    void 라인이_재생성되는지_테스트() {
        List<Block> blocks = newArrayList(Block.EXIST, Block.EXIST);
        BlockGenerator blockGenerator = new TestBlockGenerator(blocks);
        int playerNumber = blocks.size() + 1;
        Line line = Line.createLine(blockGenerator, playerNumber);

        assertThat(line.getBlocks())
                .isNotEqualTo(blocks);
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    @DisplayName("<플레이어수 - 1>만큼의 블록이 생성된다.")
    void 올바른_개수의_블록이_생성되는지_확인(List<Block> blocks, int playerNumber) {
        BlockGenerator blockGenerator = new TestBlockGenerator(new ArrayList<>(blocks));
        int expectedPlayerNumber = blocks.size() + 1;
        Line line = Line.createLine(blockGenerator, expectedPlayerNumber);

        assertThat(line.getBlocks().size())
                .isEqualTo(playerNumber - 1);
    }

    private List<Arguments> parameterProvider() {
        return List.of(
                Arguments.of(List.of(Block.EXIST), 2),
                Arguments.of(List.of(Block.EXIST, Block.EXIST), 3)
        );
    }
}