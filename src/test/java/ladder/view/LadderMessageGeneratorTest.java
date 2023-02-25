package ladder.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.BooleanGenerator;
import ladder.domain.Ladder;
import ladder.util.TestBooleanGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderMessageGeneratorTest {

    private static final String NEXT_LINE = System.lineSeparator();

    @Test
    void 사다리_출력_문자열을_생성한다() {
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(List.of(
                false, false, true,
                false, true, false,
                true, false, true
        ));
        final Ladder ladder = Ladder.generate(booleanGenerator, 3, 3);

        final String result = LadderMessageGenerator.generate(3, ladder.getLines());

        assertThat(result).isEqualTo(
                "   |   |   |---|" + NEXT_LINE
                        + "   |   |---|   |" + NEXT_LINE
                        + "   |---|   |---|"
        );
    }

    @Test
    void 사다리_가로라인의_출력_문자열은_참가자이름과_결과의이름에_따라_변경된다() {
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(List.of(
                false, false, true,
                false, true, false,
                true, false, true
        ));
        final Ladder ladder = Ladder.generate(booleanGenerator, 3, 3);

        final String result = LadderMessageGenerator.generate(1, ladder.getLines());

        assertThat(result).isEqualTo(
                " | | |-|" + NEXT_LINE
                        + " | |-| |" + NEXT_LINE
                        + " |-| |-|"
        );
    }

}
