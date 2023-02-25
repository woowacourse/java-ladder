package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.ladder.BooleanGenerator;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Position;
import ladder.util.TestBooleanGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerTest {

    @Test
    void 참가자가_정상적으로_생성된다() {
        final Player player = Player.of("name", 0);

        assertThat(player.getName()).isEqualTo("name");
    }

    @ParameterizedTest(name = "입력받은 이름과 같은 이름인지 확인한다. 이름: name, 입력받은이름: {0}, 결과 {1}")
    @CsvSource({"name,true", "notSameName,false"})
    void 입력받은_이름과_같은_이름인지_확인한다(final String name, final boolean result) {
        final Player player = Player.of("name", 0);

        assertThat(player.isSameName(name)).isEqualTo(result);
    }

    @ParameterizedTest(name = "입력받은 위치와 같은 위치인지 확인한다. 위치: {0}, 결과 {1}")
    @CsvSource({"0,true", "1,false"})
    void 입력받은_위치와_같은_위치인지_확인한다(final int position, final boolean result) {
        final Player player = Player.of("name", 0);

        assertThat(player.isSamePosition(Position.valueOf(position))).isEqualTo(result);
    }

    @Test
    void 참가자는_사다리를_받아_사다리타기를_진행한다() {
        final Player player = Player.of("name", 0);
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(List.of(
                false, false, true,
                false, true, false,
                true, false, true
        ));
        final Ladder ladder = Ladder.generate(booleanGenerator, 3, 3);

        final Position result = player.play(ladder);

        assertThat(result).isEqualTo(Position.valueOf(1));
    }
}
