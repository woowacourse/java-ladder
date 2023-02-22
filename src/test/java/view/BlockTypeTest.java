package view;

import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.Block;
import domain.Line;
import domain.Player;
import domain.Players;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BlockTypeTest {

    @Test
    void 다리모양으로_변환한다() {
        //given
        Players players = new Players(new ArrayList<>(List.of(new Player("judy"), new Player("ako"), new Player("pobi"))));
        List<Block> blocks = new ArrayList<>(List.of(new Block(true), new Block(false)));
        Line line = new Line(players, blocks);

        //when
        List<BlockType> result = BlockType.getBlockTypes(line);
        List<BlockType> expect = List.of(BlockType.CROSS, BlockType.NOT_CROSS);

        //then
        assertTrue(result.containsAll(expect));
    }
}
