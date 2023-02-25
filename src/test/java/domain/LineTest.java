package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LineTest {

    Players players;
    List<Block> blocks;

    @BeforeAll
    void initSetting() {
        List<String> nameList = new ArrayList<>(List.of("judy", "ako", "pobi"));

        players = new Players(new PlayerNames(nameList));
    }

    @Test
    void 한_column에서의_블록_개수는_플레이어_수보다_하나_적어야한다() {
        blocks = new ArrayList<>(List.of(new Block(true), new Block(false), new Block(true)));
        Assertions.assertThatThrownBy(() -> new Line(players, blocks))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 한_라인의_블록들을_반환한다() {
        blocks = new ArrayList<>(List.of(new Block(true), new Block(false)));
        Line line = new Line(players, blocks);

        List<Boolean> result = line.getBlocks();
        List<Boolean> expect = new ArrayList<>(List.of(true, false));

        Assertions.assertThat(result).isEqualTo(expect);
    }
}
