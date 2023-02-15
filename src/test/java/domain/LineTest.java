package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LineTest {

    @Test
    void 한_column에서의_블록_개수는_플레이어_수보다_하나_적어야한다() {
        int playerCount = 3;
        List<Block> blocks = new ArrayList<>(List.of(new Block(true), new Block(false), new Block(true)));
        Assertions.assertThatThrownBy(() -> new Line(playerCount, blocks))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 한_라인의_블록들을_반환한다() {
        int playerCount = 3;
        List<Block> blocks = new ArrayList<>(List.of(new Block(true), new Block(false)));
        Line line = new Line(playerCount, blocks);

        List<Boolean> result = line.getLine();
        List<Boolean> expect = new ArrayList<>(List.of(true, false));

        Assertions.assertThat(result).isEqualTo(expect);
    }
}
