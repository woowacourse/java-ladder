package view;

import domain.Block;
import domain.Line;
import domain.Player;
import domain.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import view.BlockType;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BlockTypeTest {

    @Test
    void 다리모양으로_변환한다() {
        //given
        Players players = new Players(new ArrayList<>(List.of(new Player("judy"), new Player("ako"), new Player("pobi"))));
        List<Block> blocks = new ArrayList<>(List.of(new Block(true), new Block(false)));
        Line line = new Line(players, blocks);

        //when
        List<String> result = BlockType.getBlockTypes(line);
        List<String> expect = List.of("-----", "     ");

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}