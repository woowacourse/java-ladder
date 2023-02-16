package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BlockTypeTest {

    @Test
    void 다리모양으로_변환한다() {
        Players players = new Players(new ArrayList<>(List.of(new Player("judy"), new Player("ako"), new Player("pobi"))));
        List<Block> blocks = new ArrayList<>(List.of(new Block(true), new Block(false)));
        Line line = new Line(players, blocks);

        List<String> result = BlockType.getBlockTypes(line);
        List<String> expect = new ArrayList<>(List.of("-----", "     "));

        Assertions.assertThat(result).isEqualTo(expect);
    }
}