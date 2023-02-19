package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LineTest {

    private final Players players = new Players(List.of(new Player("judy"), new Player("ako"), new Player("pobi")));

    @Test
    void 한_column에서의_블록_개수는_플레이어_수보다_하나_적어야한다() {
        //given
        List<Block> blocks = List.of(new Block(true), new Block(false), new Block(true));

        //when + then
        assertThatThrownBy(() -> new Line(players, blocks))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 한_라인의_블록들을_반환한다() {
        //given
        List<Block> blocks = List.of(new Block(true), new Block(false));
        Line line = new Line(players, blocks);

        //when
        List<Boolean> result = line.getLine();
        List<Boolean> expect = new ArrayList<>(List.of(true, false));

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}
