package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import exception.InvalidLineSizeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LineTest {

    @Test
    void 한_column에서의_블록_개수는_플레이어_수보다_하나_적어야한다() {
        //given
        List<Block> blocks = List.of(Block.createBlock(true), Block.createBlock(false), Block.createBlock(true));
        Players players = Players.generatePlayers(List.of("judy", "ako", "pobi"));

        //when + then
        assertThatThrownBy(() -> new Line(players, blocks))
            .isInstanceOf(InvalidLineSizeException.class);
    }

    @Test
    void 한_라인의_블록들을_반환한다() {
        //given
        List<Block> blocks = List.of(Block.createBlock(true), Block.createBlock(false));
        Players players = Players.generatePlayers(List.of("judy", "ako", "pobi"));
        Line line = new Line(players, blocks);

        //when
        List<Boolean> result = line.getLine();
        List<Boolean> expect = new ArrayList<>(List.of(true, false));

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    void 앞_블록이_건널_수_있으면_뒤의_불록은_건널_수_없다() {
        //given
        List<Boolean> testData = new ArrayList<>();
        testData.add(true);
        TestGenerator testGenerator = new TestGenerator(testData);
        Players players = Players.generatePlayers(List.of("judy", "ako", "pobi"));
        List<Boolean> expect = List.of(true, false);

        //when
        Line line = Line.generateLine(testGenerator, players);

        //then
        assertTrue(line.getLine().containsAll(expect));
    }

    class TestGenerator implements BooleanGenerator {

        private final List<Boolean> testData;

        private TestGenerator(List<Boolean> testData) {
            this.testData = testData;
        }

        @Override
        public boolean generate() {
            return testData.remove(0);
        }
    }
}
