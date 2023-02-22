package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderTest {

    @Test
    void 사다리를_생성하면_높이는_입력받은_높이와_같다() {
        //given
        int height = 5;
        Players players = new Players(List.of(new Player("ako"), new Player("judy"), new Player("pobi")));
        BooleanGenerator booleanGenerator = new BooleanGeneratorImplements();

        //when
        Ladder ladder = Ladder.generateLadder(height, players, booleanGenerator);

        //then
        assertThat(ladder.getLines().size()).isEqualTo(height);
    }
}
