package view;

import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.Block;
import domain.Line;
import domain.Players;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BlockTypeTest {

    @Test
    void 다리모양으로_변환한다() {
        //given
        Players players = Players.generatePlayers(List.of("judy", "ako", "pobi"));
        List<Block> blocks = List.of(Block.createBlock(true), Block.createBlock(false));
        Line line = new Line(players, blocks);

        //when
        List<BlockType> result = BlockType.getBlockTypes(line);
        List<BlockType> expect = List.of(BlockType.CROSS, BlockType.NOT_CROSS);

        //then
        assertTrue(result.containsAll(expect));
    }
}
